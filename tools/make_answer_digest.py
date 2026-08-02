#!/usr/bin/env python3
"""
make_answer_digest.py — build a redistributable digest of the Project Euler answer key.

The published answers are third-party content and are not redistributed with this
replication package. Correctness scoring still needs to be reproducible, so instead of
the answers we ship the SHA-256 hex digest of each canonical answer string. A digest
lets anyone verify a candidate answer they computed themselves, but does not hand out
the answer.

Run this once, locally, against your private answers.json. Commit the output.
Do not commit answers.json — it is listed in .gitignore.

Requires: Python 3.8+. No third-party packages.

Usage
-----
  python tools/make_answer_digest.py --answers answers.json \
      --out tools/answers.sha256.json

Input format (answers.json)
---------------------------
  {"1": "<answer>", "2": "<answer>", ...}

Output format (answers.sha256.json)
-----------------------------------
  {
    "algorithm": "sha256",
    "canonicalisation": "strip surrounding whitespace; UTF-8; no case folding",
    "count": 1002,
    "digests": {"1": "<64 hex chars>", ...}
  }

See verify_answer.py for the matching verifier.
"""

from __future__ import annotations

import argparse
import hashlib
import json
import sys


CANONICALISATION = "strip surrounding whitespace; UTF-8; no case folding"


def canonicalise(answer: str) -> str:
    """Canonical form of an answer string, shared with verify_answer.py.

    Deliberately minimal: Project Euler answers are exact strings, and anything more
    aggressive (case folding, separator stripping) would let a wrong answer verify.
    """
    return str(answer).strip()


def digest(answer: str) -> str:
    return hashlib.sha256(canonicalise(answer).encode("utf-8")).hexdigest()


def main() -> int:
    ap = argparse.ArgumentParser(description=__doc__,
                                 formatter_class=argparse.RawDescriptionHelpFormatter)
    ap.add_argument("--answers", default="answers.json",
                    help="private answer key, {problem_id: answer} (default: answers.json)")
    ap.add_argument("--out", default="tools/answers.sha256.json",
                    help="digest file to write (default: tools/answers.sha256.json)")
    args = ap.parse_args()

    try:
        with open(args.answers, encoding="utf-8") as fh:
            answers = json.load(fh)
    except FileNotFoundError:
        print(f"error: {args.answers} not found.\n"
              f"       This file is intentionally not distributed. Supply your own "
              f"copy to rebuild the digest.", file=sys.stderr)
        return 2
    except json.JSONDecodeError as exc:
        print(f"error: {args.answers} is not valid JSON: {exc}", file=sys.stderr)
        return 2

    if not isinstance(answers, dict):
        print(f"error: expected a JSON object mapping problem id -> answer, "
              f"got {type(answers).__name__}", file=sys.stderr)
        return 2

    blank = [k for k, v in answers.items() if not canonicalise(v)]
    if blank:
        print(f"warning: {len(blank)} entries have an empty answer and were skipped: "
              f"{', '.join(sorted(blank)[:10])}"
              f"{' ...' if len(blank) > 10 else ''}", file=sys.stderr)

    digests = {k: digest(v) for k, v in answers.items() if canonicalise(v)}

    payload = {
        "algorithm": "sha256",
        "canonicalisation": CANONICALISATION,
        "count": len(digests),
        "digests": dict(sorted(digests.items(), key=lambda kv: int(kv[0])
                               if kv[0].isdigit() else 10**9)),
    }

    with open(args.out, "w", encoding="utf-8", newline="\n") as fh:
        json.dump(payload, fh, indent=1, ensure_ascii=False)
        fh.write("\n")

    print(f"Wrote {args.out}: {len(digests)} digests (sha256).")
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
