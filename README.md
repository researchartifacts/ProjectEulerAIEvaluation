# Replication package on LLM adherence on Project Euler problems

**Paper:** [An Empirical Evaluation of Cost-Efficient Large Language Models on
Algorithmic Programming Tasks](https://arxiv.org/abs/2609.18052) — arXiv:2609.18052

This repository contains the generated code corpora, the static adherence analyser, and
the execution harness for a study comparing large language models on Project Euler
problems under two prompting conditions.

---

## Licensing map (Please read this first)

**Three different licences apply. There is no single licence for the repository.**

Every top-level directory is one experimental condition (`geminiflash3model/`,
`gpt54minimodel/`, `haiku45model/`, `haiku45model-cursor/`), and each one internally
mixes all three situations. So the map below is by **path pattern**, not by directory —
a per-directory table would just say "mixed" four times.

| What | Where | Licence | Commercial reuse? |
|---|---|---|---|
| **The author's own code** — analyser, harness, retrieval script, generation scripts, tests, build config | `*/src/main/java/**/{utils,controller,dto,config}/`<br>`*/src/main/java/**/*Application.java`<br>`*/src/main/java/com/example/**`<br>`*/src/test/**`<br>`*/services/adherence_analysis.py`<br>`tools/**`<br>`haiku45model-cursor/*.{py,ps1,md}`<br>`*/pom.xml`, `mvnw`, `mvnw.cmd`, `.mvn/**` | **MIT** (`LICENSE`) | Check License Definition|
| **The generated corpora** — 3,693 files of unmodified LLM output, the primary artefact | `*/src/main/java/**/services/<model>/**`<br>including `onebyone/` | **No claim asserted** (`CORPUS_TERMS.md`) | ⚠️ **Check the model provider's terms yourself** |
| **Project Euler problem statements** | *not distributed* — rebuild locally | CC BY-NC-SA 4.0 (`NOTICE`) | ❌ **No** — NonCommercial |
| **Project Euler answer key** | *not distributed* — digests only, in `tools/answers.sha256.json` | CC BY-NC-SA 4.0 (NOTICE) | ❌ **No** |
| **Build dependencies** — Spring Boot, Maven Wrapper | fetched at build time | Apache-2.0 (`NOTICE`) | Check License Definition|

**Ten-second version:** everything the author wrote is MIT and freely reusable, including
commercially. The generated Java is research data with no ownership claim. However, check the
model provider's terms before commercial use.

Per-directory summary, for completeness:

| Top-level directory | Contents | Licences present |
|---|---|---|
| `geminiflash3model/` | Gemini 3 Flash condition | MIT (harness, analyser, build) + corpus terms |
| `gpt54minimodel/` | GPT-5.4-mini condition | MIT (harness, analyser, build) + corpus terms |
| `haiku45model/` | Haiku 4.5 condition | MIT (harness, analyser, build) + corpus terms |
| `haiku45model-cursor/` | Haiku 4.5 via Cursor condition | MIT (harness, analyser, build, generation scripts, reports) + corpus terms |
| `tools/` | answer-digest tooling | MIT |

Root files, all MIT as the author's own work: `README.md`, `.gitignore`, plus the
licensing documents themselves — `LICENSE` (MIT text and scope), `NOTICE` (Project Euler
and third-party attribution), `CORPUS_TERMS.md` (terms for the generated corpora).

---

## What is missing

Two things were removed for licensing reasons. Both are reproducible.

### 1. Project Euler problem statements

The study used the statements for problems 1–1007. They are **not redistributed** —
Project Euler content is CC BY-NC-SA 4.0.

Rebuild them:

```bash
cd geminiflash3model
./mvnw -q compile exec:java -Dexec.mainClass=com.comparisonai.geminiflash3.utils.DownloadQuestions
```

This writes `problems/<n>.txt` for n = 1..1007, fetched from
`https://projecteuler.net/minimal=<n>` at one request per 200 ms. The output is
byte-identical to what the study used. Copy the resulting `problems/` directory into the
other three condition directories if you need it there.

### 2. The published answer key

Project Euler asks that answers not be republished. Instead of `answers.json`, this
package ships `tools/answers.sha256.json`: the SHA-256 digest of each canonical answer
string, for 1,007 problems.

Check an answer you computed yourself:

```bash
py tools/verify_answer.py 1 <your-computed-answer>
```

Score a whole run (JSON `{problem_id: answer}`, or CSV `problem_id,answer`):

```bash
py tools/verify_answer.py --batch extracted_answers.json
```

Exit code is 0 only if every candidate verified. If you hold your own copy of the answer
key, you can regenerate the digest file and confirm it matches:

```bash
py tools/make_answer_digest.py --answers answers.json --out tools/answers.sha256.json
```

Canonicalisation is deliberately minimal — strip surrounding whitespace, UTF-8, no case
folding — so a near-miss does not verify.

---

## Repository layout

Each condition directory is a self-contained Spring Boot project:

```
<condition>/
  pom.xml, mvnw, mvnw.cmd, .mvn/       build config                        [MIT]
  src/main/java/com/comparisonai/<pkg>/
    *Application.java                  Spring entry point                  [MIT]
    config/ controller/ dto/           execution harness, ResponseDto      [MIT]
    utils/DownloadQuestions.java       Project Euler retrieval             [MIT]
    services/
      adherence_analysis.py            static analyser                     [MIT]
      script.txt                       analyser invocations                [MIT]
      <model>/                         PROMPT 1: one class, many methods   [corpus]
      <model>/onebyone/                PROMPT 2: one file per problem      [corpus]
  src/test/                            tests                               [MIT]
  problems/                            NOT DISTRIBUTED — rebuild locally
```

The two prompting conditions are: **Prompt 1**, one `@Service` class holding
`Question1..QuestionN`; and **Prompt 2**, one file per problem
(`<Model>OneByOneQ<n>.java`). `adherence_analysis.py` auto-detects the layout.

## Running the analysis

```bash
py adherence_analysis.py <corpus_dir> --model <name> --prompt P2 \
    --pkg-prefix com.comparisonai --expected 1-1000 --out-prefix <prefix>
```

Outputs `<prefix>_methods.csv`, `<prefix>_files.csv`, `<prefix>_summary.txt`. Merge
conditions with `--merge`. See the module docstring for the C1–C6 outcome taxonomy and
`script.txt` for the exact invocations used in the study.

Correctness scoring previously took `--answers answers.json`. Since the answer key is no
longer distributed, score with `tools/verify_answer.py` against the digest file instead.

## Requirements

- JDK 21 (Spring Boot 3.1.0)
- Python 3.8+ — standard library only, no third-party packages
- Network access for the Maven wrapper and, if rebuilding, for Project Euler

## A note on the corpus

The generated Java is **research data, not working software**. It compiles — a clean
`mvnw compile` of `haiku45model-cursor` builds all 708 sources — but compiling is not the
same as solving. Much of the corpus hardcodes answers, overrides a real computation with
a literal, returns fabricated values, or puts prose where a number belongs. Those defects
are precisely the measured phenomena, classified C1–C6 by `adherence_analysis.py`.

Do not lint, reformat, or "fix" any of it. See `CORPUS_TERMS.md`.

---

## Citation

If you use this replication package, the generated corpora, or the adherence analyser,
please cite:

```bibtex
@misc{adikari2026empiricalevaluationcostefficientlarge,
      title={An Empirical Evaluation of Cost-Efficient Large Language Models on Algorithmic Programming Tasks}, 
      author={Chandimal Adikari and Nandika Herath},
      year={2026},
      eprint={2609.18052},
      archivePrefix={arXiv},
      primaryClass={cs.SE},
      url={https://arxiv.org/abs/2609.18052}, 
}
```
