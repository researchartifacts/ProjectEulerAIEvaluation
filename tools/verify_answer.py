#!/usr/bin/env python3
"""
verify_answer.py — check candidate answers against the shipped SHA-256 digest file.

This replaces the answer key for correctness scoring. It confirms whether a candidate
answer is right; it cannot tell you what the right answer is.

Requires: Python 3.8+. No third-party packages.

Usage
-----
  # single answer
  python tools/verify_answer.py 1 YOUR_COMPUTED_ANSWER

  # bulk: a JSON object of {problem_id: candidate_answer}
  python tools/verify_answer.py --batch extracted_answers.json

  # bulk, CSV: problem_id,answer  (with or without a header row)
  python tools/verify_answer.py --batch results.csv

Exit codes
----------
  0  every candidate verified
  1  at least one candidate did not verify
  2  usage or input error

Bulk mode prints a per-problem verdict and a summary line, and is what the
adherence-analysis correctness pass consumes.
"""

from __future__ import annotations

import argparse
import csv
import hashlib
import json
import os
import sys


DEFAULT_DIGESTS = os.path.join(os.path.dirname(os.path.abspath(__file__)),
                               "answers.sha256.json")


def canonicalise(answer: str) -> str:
    """Must match make_answer_digest.canonicalise exactly."""
    return str(answer).strip()


def digest(answer: str) -> str:
    return hashlib.sha256(canonicalise(answer).encode("utf-8")).hexdigest()


def load_digests(path: str) -> dict:
    try:
        with open(path, encoding="utf-8") as fh:
            payload = json.load(fh)
    except FileNotFoundError:
        print(f"error: digest file {path} not found. Rebuild it with "
              f"make_answer_digest.py.", file=sys.stderr)
        raise SystemExit(2)
    except json.JSONDecodeError as exc:
        print(f"error: {path} is not valid JSON: {exc}", file=sys.stderr)
        raise SystemExit(2)

    if payload.get("algorithm") != "sha256":
        print(f"error: unsupported digest algorithm "
              f"{payload.get('algorithm')!r}", file=sys.stderr)
        raise SystemExit(2)
    return payload.get("digests", {})


def load_batch(path: str) -> dict:
    if path.lower().endswith(".json"):
        with open(path, encoding="utf-8") as fh:
            data = json.load(fh)
        if not isinstance(data, dict):
            print("error: batch JSON must be an object {problem_id: answer}",
                  file=sys.stderr)
            raise SystemExit(2)
        return {str(k): v for k, v in data.items()}

    out = {}
    with open(path, newline="", encoding="utf-8") as fh:
        for row in csv.reader(fh):
            if len(row) < 2:
                continue
            pid, ans = row[0].strip(), row[1].strip()
            if not pid or pid.lower() in ("problem", "problem_id", "id", "question"):
                continue  # header
            out[pid] = ans
    return out


def main() -> int:
    ap = argparse.ArgumentParser(description=__doc__,
                                 formatter_class=argparse.RawDescriptionHelpFormatter)
    ap.add_argument("problem", nargs="?", help="problem id, e.g. 1")
    ap.add_argument("answer", nargs="?", help="candidate answer")
    ap.add_argument("--batch", help="JSON object or CSV of candidate answers")
    ap.add_argument("--digests", default=DEFAULT_DIGESTS,
                    help="digest file (default: tools/answers.sha256.json)")
    ap.add_argument("--quiet", action="store_true",
                    help="suppress per-problem lines in batch mode")
    args = ap.parse_args()

    digests = load_digests(args.digests)

    if args.batch:
        candidates = load_batch(args.batch)
    elif args.problem is not None and args.answer is not None:
        candidates = {str(args.problem): args.answer}
    else:
        ap.error("give either PROBLEM and ANSWER, or --batch FILE")
        return 2

    ok = wrong = unknown = 0
    for pid in sorted(candidates, key=lambda k: int(k) if k.isdigit() else 10**9):
        expected = digests.get(pid)
        if expected is None:
            unknown += 1
            if not args.quiet:
                print(f"{pid}: NO DIGEST (problem not in digest file)")
            continue
        if digest(candidates[pid]) == expected:
            ok += 1
            if not args.quiet:
                print(f"{pid}: CORRECT")
        else:
            wrong += 1
            if not args.quiet:
                print(f"{pid}: WRONG")

    total = ok + wrong + unknown
    print(f"verified {ok}/{total} correct, {wrong} wrong, {unknown} without a digest")
    return 0 if wrong == 0 and unknown == 0 else 1


if __name__ == "__main__":
    raise SystemExit(main())
