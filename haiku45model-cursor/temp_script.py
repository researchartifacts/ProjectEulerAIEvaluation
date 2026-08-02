import os
import re
import json

REPO_DIR = os.path.dirname(os.path.abspath(__file__))
problem_dir = os.path.join(REPO_DIR, "problems", "101to200")
output_file = os.path.join(REPO_DIR, "problems_list.json")

problems = {}
for filename in os.listdir(problem_dir):
    if filename.endswith(".txt"):
        problem_num = int(filename[:-4])
        filepath = os.path.join(problem_dir, filename)
        with open(filepath, 'r', encoding='utf-8') as f:
            content = f.read()
        problems[problem_num] = {
            "number": problem_num,
            "content": content[:500]  # First 500 chars
        }

# Sort by problem number
sorted_problems = {k: problems[k] for k in sorted(problems.keys())}

with open(output_file, 'w') as f:
    json.dump(sorted_problems, f, indent=2)

print(f"Created problems list with {len(sorted_problems)} problems")
print("Sample problem 101:")
print(sorted_problems[101])
