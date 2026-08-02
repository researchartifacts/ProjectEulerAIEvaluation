#!/usr/bin/env python3
"""
adherence_analysis.py — static adherence analysis for LLM-generated
Project Euler solutions in Spring Boot services.

Handles BOTH experimental layouts:
  * one-file-per-problem   (Prompt 2: Gemini3FlashOneByOneQ42.java)
  * single-class-many-methods (Prompt 1: one @Service with Question1..QuestionN)
Layout is auto-detected; override with --layout.

Requires: Python 3.8+. No third-party packages.

Usage
-----
  # one condition
  python adherence_analysis.py SRC_DIR --model haiku45 --prompt P1 \
      [--answers answers.json] [--expected 1-1000] [--out-prefix haiku45_p1]

  # merge conditions already analysed
  python adherence_analysis.py --merge out1_methods.csv out2_methods.csv \
      --out-prefix combined

Outputs
-------
  <prefix>_methods.csv   one row per primary method  (the analysis unit)
  <prefix>_files.csv     one row per source file
  <prefix>_summary.txt   human-readable summary (also printed)

Outcome taxonomy
----------------
  C1 genuine computation attempt
  C2 real code present but answer overridden with a literal
  C3 bare hardcoded constant, no computation
  C4 fabricated value, self-declared placeholder
  C5 prose string where a value belongs (non-attempt)
  C6 setAnswer never called
  C3-C6 are non-attempts. With --answers, C2-C4 are further split into
  *_correct (memorisation signal) and *_wrong (fabrication signal).
"""

from __future__ import annotations
import argparse
import csv
import json
import os
import re
import statistics as st
import sys
from collections import Counter, defaultdict

# ---------------------------------------------------------------------------
# Configurable expectations
# ---------------------------------------------------------------------------
DEFAULT_DTO = 'ResponseDto'
DEFAULT_SETTER = 'setAnswer'
DEFAULT_METHOD_PATTERN = r'(?i)question(\d+)'

# ---------------------------------------------------------------------------
# Lexical helpers
# ---------------------------------------------------------------------------

def strip_comments(src: str):
    """Blank out comments (preserving offsets) and return (code, comment_list)."""
    out, comments = [], []
    i, n = 0, len(src)
    while i < n:
        c = src[i]
        if c == '"':
            out.append(c); i += 1
            while i < n:
                out.append(src[i])
                if src[i] == '\\' and i + 1 < n:
                    out.append(src[i + 1]); i += 2; continue
                if src[i] == '"':
                    i += 1; break
                i += 1
            continue
        if c == "'":
            out.append(c); i += 1
            while i < n:
                out.append(src[i])
                if src[i] == '\\' and i + 1 < n:
                    out.append(src[i + 1]); i += 2; continue
                if src[i] == "'":
                    i += 1; break
                i += 1
            continue
        if c == '/' and i + 1 < n and src[i + 1] == '/':
            j = src.find('\n', i); j = n if j == -1 else j
            comments.append(src[i:j]); out.append(' ' * (j - i)); i = j
            continue
        if c == '/' and i + 1 < n and src[i + 1] == '*':
            j = src.find('*/', i + 2); j = n if j == -1 else j + 2
            comments.append(src[i:j]); out.append(' ' * (j - i)); i = j
            continue
        out.append(c); i += 1
    return ''.join(out), comments


def match_block(code: str, open_idx: int) -> int:
    depth, i, n = 0, open_idx, len(code)
    while i < n:
        if code[i] == '{':
            depth += 1
        elif code[i] == '}':
            depth -= 1
            if depth == 0:
                return i + 1
        i += 1
    return -1


METHOD_RE = re.compile(
    r'(?P<mods>(?:(?:public|private|protected|static|final|synchronized|abstract)\s+)*)'
    r'(?P<ret>[A-Za-z_$][\w$<>,\[\].\s]*?)\s+'
    r'(?P<name>[A-Za-z_$][\w$]*)\s*'
    r'\((?P<params>[^)]*)\)\s*'
    r'(?:throws\s+[\w$.,\s]+)?\s*\{'
)
CLASS_RE = re.compile(r'\b(?:class|interface|enum|record)\s+([A-Za-z_$][\w$]*)')

# ---------------------------------------------------------------------------
# Semantic patterns
# ---------------------------------------------------------------------------
NUM = r'-?[\d_]*\.?[\d_]+(?:[eE][-+]?\d+)?[lLfFdDbB]?'
NUM_FULL = re.compile(r'^' + NUM + r'$')
STR_FULL = re.compile(r'^"(?:[^"\\]|\\.)*"$', re.S)
IDENT = re.compile(r'^[A-Za-z_$][\w$]*$')
NUMERIC_TEXT = re.compile(r'^[\d\s.,\-+eE]+$')

WRAP = re.compile(r'^(?:String\.valueOf|Long\.toString|Integer\.toString|'
                  r'Double\.toString|BigInteger\.valueOf|BigDecimal\.valueOf|'
                  r'String\.format|Objects\.toString)\s*\((?P<inner>.*)\)$', re.S)
TOSTR = re.compile(r'^(?P<inner>.*?)\.toString\s*\(\s*\)$', re.S)

NOOP_CALL = re.compile(r'\b(?:setAnswer|String\.valueOf|Long\.toString|'
                       r'Integer\.toString|Double\.toString|String\.format|'
                       r'toString|valueOf|System\.\w+|printf|println|print)\s*\(')

PROSE = re.compile(r'(?i)\b(logic|placeholder|calculation|compute[ds]?|result of|'
                   r'implement\w*|todo|derived|formula|answer for|value of|'
                   r'requires|omitted|simulation|approach|based on|solution|'
                   r'see (above|below)|not implemented|n/?a)\b')
PLACEHOLDER_CMT = re.compile(r'(?i)(placeholder|for demonstration|dummy value|'
                             r'not the actual|illustrative|stub|'
                             r'in a real (scenario|implementation|solution)|'
                             r'would (involve|require|be)|as requested|hardcod|'
                             r'pre-?computed|known (value|result|answer)|'
                             r'simplified for)')
CLAIMED = re.compile(r'(?i)((correct|known|actual|expected|final|true)\s+'
                     r'(result|answer|value)|(answer|result)\s+(is|for)\b)')
STUB = re.compile(r'(?i)\b(TODO|FIXME|UnsupportedOperationException|'
                  r'not\s+implemented)\b')

CONTROL = {'if', 'for', 'while', 'switch', 'return', 'catch', 'do', 'else',
           'try', 'synchronized', 'assert'}


def split_args(inner: str):
    parts, depth, cur = [], 0, ''
    for ch in inner:
        if ch == ',' and depth == 0:
            parts.append(cur); cur = ''; continue
        if ch in '([{':
            depth += 1
        elif ch in ')]}':
            depth -= 1
        cur += ch
    parts.append(cur)
    return [p.strip() for p in parts]


def unwrap(expr: str) -> str:
    """Strip valueOf/format/toString wrappers down to the innermost expression."""
    prev = None
    while expr != prev:
        prev = expr = expr.strip()
        m = WRAP.match(expr)
        if m:
            expr = split_args(m.group('inner'))[-1]
            continue
        m = TOSTR.match(expr)
        if m:
            expr = m.group('inner').strip()
    return expr


def resolve_arg(expr: str, body: str, depth: int = 0):
    """Resolve the setAnswer argument to its source.
    Returns (kind, text) where kind in {num_lit, str_lit, expr, none}."""
    if not expr:
        return 'none', ''
    expr = unwrap(expr)
    if NUM_FULL.match(expr):
        return 'num_lit', expr
    if STR_FULL.match(expr):
        return 'str_lit', expr[1:-1]
    if depth < 3 and IDENT.match(expr):
        assigns = re.findall(r'\b' + re.escape(expr) + r'\s*=\s*([^;]+);', body)
        decls = re.findall(r'\b\w[\w<>\[\], .]*\s+' + re.escape(expr) +
                           r'\s*=\s*([^;]+);', body)
        cands = [a.strip() for a in assigns + decls]
        mutated = re.search(r'\b' + re.escape(expr) +
                            r'\s*(?:\+\+|--|[-+*/%|&^]=)', body)
        if cands and not mutated:
            kinds = [resolve_arg(c, body, depth + 1) for c in dict.fromkeys(cands)]
            if kinds and all(k[0] in ('num_lit', 'str_lit') for k in kinds):
                # prefer the most specific (longest) literal
                return max(kinds, key=lambda k: len(k[1]))
    return 'expr', expr


def count_real_calls(body: str) -> int:
    n = 0
    for m in re.finditer(r'\b([A-Za-z_$][\w$]*)\s*\(', body):
        name = m.group(1)
        if name in CONTROL:
            continue
        if NOOP_CALL.match(body[m.start():]):
            continue
        if re.search(r'\bnew\s+$', body[max(0, m.start() - 6):m.start()]):
            continue
        if re.match(r'(?:set|get)[A-Z]', name):
            continue
        n += 1
    return n


def max_loop_nesting(body: str) -> int:
    depth = best = 0
    for m in re.finditer(r'\b(?:for|while)\s*\(|[{}]', body):
        t = m.group(0)
        if t == '}':
            depth = max(0, depth - 1)
        elif t != '{':
            depth += 1
            best = max(best, depth)
    return best


def norm_answer(s: str) -> str:
    """Normalise an answer for comparison."""
    s = str(s).strip().rstrip('lLfFdD')
    s = s.replace('_', '').replace(',', '').replace(' ', '')
    if re.fullmatch(r'-?\d+', s):
        return str(int(s))
    try:
        f = float(s)
        return f'{f:.10g}'
    except ValueError:
        return s.lower()


# ---------------------------------------------------------------------------
# Core analysis
# ---------------------------------------------------------------------------

def analyse_method(m, body_code, body_comments, cfg):
    name = m.group('name')
    pid_m = re.fullmatch(cfg['method_pattern'], name)
    pid = int(pid_m.group(1)) if pid_m else None

    # --- signature ------------------------------------------------------
    sig = []
    if not pid_m:
        sig.append('name_pattern')
    if 'public' not in m.group('mods'):
        sig.append('not_public')
    if 'static' in m.group('mods'):
        sig.append('is_static')
    if m.group('ret').strip() != cfg['dto']:
        sig.append('ret=' + m.group('ret').strip())
    if m.group('params').strip():
        sig.append('has_params')

    # --- DTO contract ---------------------------------------------------
    dto_new = bool(re.search(r'new\s+' + re.escape(cfg['dto']) + r'\s*\(', body_code))
    sa = re.search(r'\.\s*' + re.escape(cfg['setter']) + r'\s*\(', body_code)
    ret_var = bool(re.search(r'return\s+[A-Za-z_$][\w$]*\s*;', body_code))

    arg = ''
    if sa:
        d, i = 1, sa.end()
        while i < len(body_code) and d:
            if body_code[i] == '(':
                d += 1
            elif body_code[i] == ')':
                d -= 1
            i += 1
        arg = body_code[sa.end():i - 1].strip()

    kind, resolved = resolve_arg(arg, body_code)

    loops = len(re.findall(r'\b(?:for|while|do)\s*[({]', body_code))
    streams = len(re.findall(r'\.(?:stream|range|rangeClosed|iterate|generate)\s*\(',
                             body_code))
    calls = count_real_calls(body_code)
    recursion = bool(re.search(r'\b' + re.escape(name) + r'\s*\(', body_code[1:]))
    computes = bool(loops or streams or calls or recursion)

    ctext = ' '.join(body_comments)
    ack = bool(PLACEHOLDER_CMT.search(ctext))
    claims = bool(CLAIMED.search(ctext))

    prose = kind == 'str_lit' and bool(PROSE.search(resolved)) \
        and not NUMERIC_TEXT.match(resolved or 'x')
    literal_answer = kind == 'num_lit' or (
        kind == 'str_lit' and bool(NUMERIC_TEXT.match(resolved or 'x')))

    if not sa:
        outcome = 'C6_no_setanswer'
    elif prose:
        outcome = 'C5_narrative_nonattempt'
    elif literal_answer and not computes and ack:
        outcome = 'C4_ack_placeholder'
    elif literal_answer and not computes:
        outcome = 'C3_hardcoded_constant'
    elif literal_answer and computes:
        outcome = 'C2_literal_despite_code'
    else:
        outcome = 'C1_computed'

    return dict(
        problem_id=pid if pid is not None else '',
        method=name,
        signature_ok=int(not sig), signature_issues=';'.join(sig),
        dto_new=int(dto_new), setter_called=int(bool(sa)), returns_var=int(ret_var),
        dto_contract_ok=int(dto_new and bool(sa) and ret_var),
        raw_arg=arg[:70], resolved=resolved[:60], resolved_kind=kind,
        outcome=outcome, computes=int(computes),
        loops=loops, streams=streams, real_calls=calls, recursion=int(recursion),
        nesting=max_loop_nesting(body_code),
        ack_placeholder=int(ack), claims_answer=int(claims),
        stub=int(bool(STUB.search(body_code)) or bool(STUB.search(ctext))),
        body_lines=len([l for l in body_code.split('\n') if l.strip()]),
        comment_lines=len(body_comments),
    )


def analyse_file(path, cfg):
    raw = open(path, encoding='utf-8', errors='replace').read()
    code, _ = strip_comments(raw)
    fn = os.path.basename(path)

    fid = re.search(r'(?i)q(\d+)\D*$', os.path.splitext(fn)[0])
    file_pid = int(fid.group(1)) if fid else None

    pkg_m = re.search(r'package\s+([\w.]+)\s*;', code)
    pkg = pkg_m.group(1) if pkg_m else ''
    imports = re.findall(r'import\s+(?:static\s+)?([\w.*]+)\s*;', code)
    dto_imp = [i for i in imports if cfg['dto'] in i]
    classes = CLASS_RE.findall(code)

    primaries, helpers = [], []
    for m in METHOD_RE.finditer(code):
        try:
            oi = code.index('{', m.end() - 1)
        except ValueError:
            continue
        end = match_block(code, oi)
        if end == -1:
            continue
        bcode, braw = code[oi:end], raw[oi:end]
        _, bc = strip_comments(braw)
        if re.fullmatch(cfg['method_pattern'], m.group('name')):
            primaries.append(analyse_method(m, bcode, bc, cfg))
        else:
            helpers.append(m.group('name'))

    for r in primaries:
        r['file'] = fn
        r['file_pid'] = file_pid if file_pid is not None else ''
        r['id_mismatch'] = int(file_pid is not None and r['problem_id'] != ''
                               and file_pid != r['problem_id'])

    frow = dict(
        file=fn, file_pid=file_pid if file_pid is not None else '',
        package=pkg,
        pkg_ok=int(bool(cfg['pkg_prefix']) and pkg.startswith(cfg['pkg_prefix']))
        if cfg['pkg_prefix'] else '',
        dto_import=';'.join(dto_imp),
        dto_import_ok=int(bool(dto_imp) and
                          (not cfg['pkg_prefix'] or
                           any(i.startswith(cfg['pkg_prefix']) for i in dto_imp))),
        has_service=int(bool(re.search(r'@Service\b', code))),
        class_count=len(classes), primary_count=len(primaries),
        helper_count=len(helpers), helpers=';'.join(helpers[:8]),
        crlf=int('\r\n' in raw), loc=raw.count('\n') + 1,
    )
    return primaries, frow


def parse_id_spec(spec):
    ids = set()
    for part in spec.split(','):
        part = part.strip()
        if '-' in part:
            a, b = part.split('-', 1)
            ids.update(range(int(a), int(b) + 1))
        elif part:
            ids.add(int(part))
    return ids


# ---------------------------------------------------------------------------
# Reporting
# ---------------------------------------------------------------------------
ORDER = ['C1_computed', 'C2_literal_despite_code', 'C3_hardcoded_constant',
         'C4_ack_placeholder', 'C5_narrative_nonattempt', 'C6_no_setanswer']
LABEL = {
    'C1_computed':             'C1  Genuine computation attempt',
    'C2_literal_despite_code': 'C2  Literal answer alongside real code',
    'C3_hardcoded_constant':   'C3  Hardcoded constant, no computation',
    'C4_ack_placeholder':      'C4  Fabricated value, self-declared placeholder',
    'C5_narrative_nonattempt': 'C5  Prose string in place of a value',
    'C6_no_setanswer':         'C6  setter never called',
}


def report(rows, frows, answers, expected, cfg, band=100):
    L = []
    def w(s=''):
        L.append(s); print(s)

    n, nf = len(rows), len(frows)
    if not n:
        w('No primary methods found. Check --method-pattern.')
        return '\n'.join(L)

    w(f'CONDITION: model={cfg["model"]}  prompt={cfg["prompt"]}  layout={cfg["layout"]}')
    w(f'FILES: {nf}    PRIMARY METHODS: {n}    '
      f'HELPERS: {sum(f["helper_count"] for f in frows)}')
    w()
    w('--- STRUCTURAL CONFORMANCE ---')
    def fp(k):
        c = sum(1 for f in frows if f.get(k) == 1)
        return f'{c}/{nf} ({100*c/nf:.1f}%)'
    w(f'  @Service present           : {fp("has_service")}')
    if cfg['pkg_prefix']:
        w(f'  package matches prefix     : {fp("pkg_ok")}')
    w(f'  DTO import present/correct  : {fp("dto_import_ok")}')
    w(f'  files with >1 class         : {sum(1 for f in frows if f["class_count"]>1)}')
    w(f'  files with >1 primary method: {sum(1 for f in frows if f["primary_count"]>1)}')
    w(f'  files with 0 primary methods: {sum(1 for f in frows if f["primary_count"]==0)}')
    pk = Counter(f['package'] for f in frows).most_common(3)
    w(f'  package variants            : {pk}')

    w()
    w('--- PER-METHOD ADHERENCE ---')
    def mp(pred):
        c = sum(1 for r in rows if pred(r))
        return f'{c:5d}/{n} ({100*c/n:5.1f}%)'
    w(f'  signature conformant        : {mp(lambda r: r["signature_ok"]==1)}')
    w(f'  DTO contract satisfied      : {mp(lambda r: r["dto_contract_ok"]==1)}')
    w(f'    new {cfg["dto"]:<20s}: {mp(lambda r: r["dto_new"]==1)}')
    w(f'    {cfg["setter"]}() called{"":<9s}: {mp(lambda r: r["setter_called"]==1)}')
    w(f'    returns a variable        : {mp(lambda r: r["returns_var"]==1)}')
    w(f'  stub/TODO present           : {mp(lambda r: r["stub"]==1)}')
    w(f'  file/method ID mismatch     : {mp(lambda r: r["id_mismatch"]==1)}')
    si = Counter(x for r in rows for x in r['signature_issues'].split(';') if x)
    if si:
        w(f'  signature issue types       : {si.most_common()}')

    w()
    w('--- OUTCOME TAXONOMY ---')
    cnt = Counter(r['outcome'] for r in rows)
    for k in ORDER:
        v = cnt.get(k, 0)
        w(f'  {LABEL[k]:48s} {v:5d} ({100*v/n:5.1f}%) {"#"*int(40*v/n)}')
    na = sum(cnt.get(k, 0) for k in ORDER[2:])
    w()
    w(f'  NON-ATTEMPT (C3-C6)         : {na:5d}/{n} ({100*na/n:5.1f}%)')
    w(f'  ATTEMPT     (C1-C2)         : {n-na:5d}/{n} ({100*(n-na)/n:5.1f}%)')

    # correctness of literals, if ground truth available
    if answers:
        w()
        w('--- LITERAL vs GROUND TRUTH (memorisation vs fabrication) ---')
        buckets = Counter()
        for r in rows:
            if r['outcome'] not in ('C2_literal_despite_code',
                                    'C3_hardcoded_constant',
                                    'C4_ack_placeholder'):
                continue
            truth = answers.get(str(r['problem_id']))
            if truth is None:
                buckets['no_ground_truth'] += 1
                r['literal_correct'] = ''
                continue
            ok = norm_answer(r['resolved']) == norm_answer(truth)
            r['literal_correct'] = int(ok)
            buckets['correct' if ok else 'wrong'] += 1
        tot = buckets['correct'] + buckets['wrong']
        if tot:
            w(f'  hardcoded literal MATCHES answer : {buckets["correct"]:5d}/{tot} '
              f'({100*buckets["correct"]/tot:5.1f}%)   <- memorisation signal')
            w(f'  hardcoded literal is WRONG       : {buckets["wrong"]:5d}/{tot} '
              f'({100*buckets["wrong"]/tot:5.1f}%)   <- fabrication signal')
        if buckets['no_ground_truth']:
            w(f'  (no ground truth for {buckets["no_ground_truth"]} literals)')

    w()
    w('--- SELF-DISCLOSURE ---')
    ackn = sum(r['ack_placeholder'] for r in rows)
    clm = sum(r['claims_answer'] for r in rows)
    w(f'  comments admit placeholder/hardcoding : {ackn:5d} ({100*ackn/n:5.1f}%)')
    w(f'  comments assert a real answer         : {clm:5d} ({100*clm/n:5.1f}%)')
    w(f'  assert real answer AND no computation : '
      f'{sum(1 for r in rows if r["claims_answer"] and not r["computes"]):5d}'
      f'   <- misleading subset')

    # bands
    ids = [r['problem_id'] for r in rows if r['problem_id'] != '']
    if ids and band:
        w()
        w(f'--- BY PROBLEM BAND (width {band}) ---')
        bd = defaultdict(Counter)
        for r in rows:
            if r['problem_id'] == '':
                continue
            bd[(r['problem_id'] - 1)//band*band + 1][r['outcome']] += 1
        w('  ' + 'band'.ljust(12) + 'n'.rjust(4) +
          ''.join(k[:2].rjust(5) for k in ORDER) + 'non-att%'.rjust(10))
        for b in sorted(bd):
            c = bd[b]; t = sum(c.values())
            nb = sum(c.get(k, 0) for k in ORDER[2:])
            w(f'  {b:4d}-{b+band-1:<7d}{t:4d}' +
              ''.join(str(c.get(k, 0)).rjust(5) for k in ORDER) +
              f'{100*nb/t:9.1f}%')

    # coverage
    if expected:
        found = {r['problem_id'] for r in rows if r['problem_id'] != ''}
        missing = sorted(expected - found)
        halluc = sorted(found - expected)
        w()
        w('--- COVERAGE ---')
        w(f'  expected {len(expected)}, found {len(found)}')
        w(f'  MISSING (silent skip)  : {len(missing)}  {missing[:40]}'
          f'{" ..." if len(missing) > 40 else ""}')
        w(f'  HALLUCINATED (not given): {len(halluc)}  {halluc[:40]}'
          f'{" ..." if len(halluc) > 40 else ""}')
        if missing:
            runs, s, p = [], missing[0], missing[0]
            for x in missing[1:]:
                if x == p + 1:
                    p = x
                else:
                    runs.append((s, p)); s = p = x
            runs.append((s, p))
            long_runs = [(a, b, b - a + 1) for a, b in runs if b - a + 1 >= 3]
            if long_runs:
                w(f'  contiguous gaps >=3    : {long_runs}   '
                  f'<- batch-level failure, not per-problem')

    w()
    w('--- COMPLEXITY PROXIES (C1 subset) ---')
    c1 = [r for r in rows if r['outcome'] == 'C1_computed']
    if c1:
        w(f'  loop nesting: {dict(sorted(Counter(r["nesting"] for r in c1).items()))}')
        w(f'  delegates to helpers: {sum(1 for r in c1 if r["real_calls"]>0)}/{len(c1)}')
        w(f'  recursive          : {sum(1 for r in c1 if r["recursion"])}/{len(c1)}')
    w('  median body_lines by outcome: ' + ', '.join(
        f'{k[:2]}={st.median([r["body_lines"] for r in rows if r["outcome"]==k]):.0f}'
        for k in ORDER if any(r['outcome'] == k for r in rows)))
    return '\n'.join(L)


# ---------------------------------------------------------------------------
# Merge mode
# ---------------------------------------------------------------------------

def merge(paths, prefix):
    all_rows = []
    for p in paths:
        all_rows.extend(list(csv.DictReader(open(p, encoding='utf-8'))))
    conds = sorted({(r['model'], r['prompt']) for r in all_rows})
    print(f'Merged {len(all_rows)} rows across {len(conds)} conditions\n')
    hdr = f'{"model":16s}{"prompt":10s}{"n":>6s}' + \
        ''.join(k[:2].rjust(7) for k in ORDER) + f'{"non-att%":>10s}'
    print(hdr); print('-' * len(hdr))
    for m, pr in conds:
        sub = [r for r in all_rows if r['model'] == m and r['prompt'] == pr]
        c = Counter(r['outcome'] for r in sub)
        na = sum(c.get(k, 0) for k in ORDER[2:])
        print(f'{m:16s}{pr:10s}{len(sub):6d}' +
              ''.join(str(c.get(k, 0)).rjust(7) for k in ORDER) +
              f'{100*na/len(sub):9.1f}%')
    out = f'{prefix}_methods.csv'
    with open(out, 'w', newline='', encoding='utf-8') as fh:
        wr = csv.DictWriter(fh, fieldnames=list(all_rows[0].keys()),
                            extrasaction='ignore')
        wr.writeheader(); wr.writerows(all_rows)
    print(f'\nWrote {out}')
    print('\nFor paired significance testing across conditions, pivot on '
          'problem_id and use:\n'
          '  statsmodels.stats.contingency_tables.cochrans_q  (3+ models)\n'
          '  statsmodels.stats.contingency_tables.mcnemar     (pairwise, then Holm)')


# ---------------------------------------------------------------------------
def main():
    ap = argparse.ArgumentParser(description=__doc__,
                                 formatter_class=argparse.RawDescriptionHelpFormatter)
    ap.add_argument('source', nargs='?', help='directory of .java files')
    ap.add_argument('--model', default='model')
    ap.add_argument('--prompt', default='prompt')
    ap.add_argument('--layout', choices=['auto', 'per_problem', 'single_class'],
                    default='auto')
    ap.add_argument('--answers', help='JSON {"<problem>":"<answer>", ...}')
    ap.add_argument('--expected', help='problem IDs actually supplied, e.g. 1-1000')
    ap.add_argument('--dto', default=DEFAULT_DTO)
    ap.add_argument('--setter', default=DEFAULT_SETTER)
    ap.add_argument('--method-pattern', default=DEFAULT_METHOD_PATTERN,
                    help='regex with one capture group for the problem number')
    ap.add_argument('--pkg-prefix', default='',
                    help='expected package prefix, e.g. com.comparisonai')
    ap.add_argument('--band', type=int, default=100, help='0 to disable band table')
    ap.add_argument('--out-prefix', default='adherence')
    ap.add_argument('--merge', nargs='+', metavar='CSV',
                    help='merge previously produced *_methods.csv files')
    a = ap.parse_args()

    if a.merge:
        merge(a.merge, a.out_prefix); return
    if not a.source:
        ap.error('source directory required (or use --merge)')

    answers = {}
    if a.answers:
        answers = {str(k): str(v) for k, v in
                   json.load(open(a.answers, encoding='utf-8')).items()}

    java = [os.path.join(dp, f) for dp, _, fs in os.walk(a.source)
            for f in fs if f.endswith('.java')]
    if not java:
        sys.exit(f'No .java files under {a.source}')

    cfg = dict(model=a.model, prompt=a.prompt, dto=a.dto, setter=a.setter,
               method_pattern=a.method_pattern, pkg_prefix=a.pkg_prefix,
               layout=a.layout)

    rows, frows = [], []
    for p in sorted(java):
        pr, fr = analyse_file(p, cfg)
        rows.extend(pr); frows.append(fr)

    if a.layout == 'auto':
        avg = len(rows) / max(1, len(frows))
        cfg['layout'] = 'single_class' if avg > 3 else 'per_problem'

    for r in rows:
        r['model'] = a.model
        r['prompt'] = a.prompt

    expected = parse_id_spec(a.expected) if a.expected else None
    text = report(rows, frows, answers, expected, cfg, a.band)

    cols = ['model', 'prompt', 'problem_id', 'method', 'file', 'file_pid',
            'id_mismatch', 'outcome', 'resolved', 'resolved_kind', 'raw_arg',
            'literal_correct', 'computes', 'loops', 'streams', 'real_calls',
            'recursion', 'nesting', 'signature_ok', 'signature_issues',
            'dto_new', 'setter_called', 'returns_var', 'dto_contract_ok',
            'ack_placeholder', 'claims_answer', 'stub', 'body_lines',
            'comment_lines']
    mp = f'{a.out_prefix}_methods.csv'
    with open(mp, 'w', newline='', encoding='utf-8') as fh:
        wr = csv.DictWriter(fh, fieldnames=cols, extrasaction='ignore')
        wr.writeheader()
        for r in rows:
            r.setdefault('literal_correct', '')
            wr.writerow(r)
    fpath = f'{a.out_prefix}_files.csv'
    with open(fpath, 'w', newline='', encoding='utf-8') as fh:
        wr = csv.DictWriter(fh, fieldnames=list(frows[0].keys()))
        wr.writeheader(); wr.writerows(frows)
    with open(f'{a.out_prefix}_summary.txt', 'w', encoding='utf-8') as fh:
        fh.write(text + '\n')
    print(f'\nWrote {mp}, {fpath}, {a.out_prefix}_summary.txt')


if __name__ == '__main__':
    main()
