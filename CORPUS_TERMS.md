# Terms for the generated code corpora

## What this covers

The 3,693 generated files under:

```
geminiflash3model/src/main/java/com/comparisonai/geminiflash3/services/gemini3flash/
gpt54minimodel/src/main/java/com/comparisonai/gpt54minimodel/services/gpt54mini/
haiku45model/src/main/java/com/comparisonai/haiku45model/services/haiku45model/
haiku45model-cursor/src/main/java/com/comparisonai/haiku45modelcursor/services/haiku45modelcursor/
```

including the `onebyone/` subdirectories: 3,676 `.java` files plus 17 files described
below. These are the primary research artefact.

Breakdown by condition:

| directory | files |
|---|---|
| `geminiflash3model/.../gemini3flash/` | 982 `.java` + 17 |
| `gpt54minimodel/.../gpt54mini/` | 1,011 `.java` |
| `haiku45model/.../haiku45model/` | 979 `.java` |
| `haiku45model-cursor/.../haiku45modelcursor/` | 704 `.java` |

### The 17 files with a non-`.java` suffix

Seventeen files in `gemini3flash/onebyone/` have names ending `…Q<n>.java正式版的`
("official version of"), e.g. `Gemini3FlashOneByOneQ210.java正式版的`. Each has a
same-numbered `.java` twin, and **the two are not duplicates** — they are different
generation variants of the same problem. The suffixed file is typically the shorter one
carrying a hardcoded literal answer, while the twin contains a computation attempt.
Compare `Q210`: the suffixed file is 597 bytes ending in
`responseDto.setAnswer(159817477017505020L);`, the twin is 13,472 bytes of derivation.

They are preserved under their original names. Renaming them to `.java` would collide
with their twins, and picking a different name would be an arbitrary editorial act on
research data.

**Note for anyone re-running the analysis:** `adherence_analysis.py` globs `*.java`, so
these 17 files are not currently picked up. If they are meant to be in the analysed set,
the glob needs widening; that is a study-design decision, not a packaging one.

## Status

These files are **unmodified output of large language models**, retained exactly as
generated so that the reported results can be independently verified.

The author asserts **no copyright** over them. They are not the author's creative work,
and no ownership claim is made. Their legal status depends on the terms of the model
provider in force at generation time, which differ between providers and change over
time; this repository does not attempt to resolve that question, and nothing here should
be read as a grant of rights the author does not hold.

They are made available for **research use**: reading, analysis, measurement, replication
of the reported results, and verification of the analysis pipeline.

If you intend to reuse this code for anything other than research — in particular
commercially, or as a component of software you distribute — check the relevant model
provider's terms yourself. Do not rely on this file for that.

## Integrity

Every file is byte-identical to what the model produced, with **two exceptions out of
3,693**, both made solely to remove the author's identity for double-blind review:

| file | change |
|---|---|
| `haiku45model-cursor/.../onebyone/Haiku45OneByOneQ54.java` | line 64, one string literal: an absolute filesystem path replaced with `<REDACTED_PATH>` |
| `haiku45model-cursor/.../onebyone/Haiku45OneByOneQ59.java` | line 22, one string literal: an absolute filesystem path replaced with `<REDACTED_PATH>` |

In both cases the model had emitted the author's working directory, echoed from the
elicitation context. The redaction touches one string literal inside a fallback branch in
each file. No control flow, no computation, no `setAnswer` call, and no comment was
altered, so the adherence classification (C1–C6) of both files is unchanged.

No other corpus file was edited, reformatted, linted, or corrected in any way.

## Please do not

- Reformat, lint, or "fix" these files. Their defects — hardcoded constants, computations
  overridden by literals, fabricated values, placeholder prose where a number belongs —
  are the measured phenomena. Note the corpus does compile; compiling is not solving.
- Treat them as working solutions to Project Euler problems. Many are not, by design and
  by finding.
- Redistribute them alongside the Project Euler problem statements or answer key.
  See `NOTICE`.
