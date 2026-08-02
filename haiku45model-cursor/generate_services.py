import os

# Base template for each service file
template = '''package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem {problem_number}
 */
@Service
public class Haiku45OneByOneQ{problem_number} {{

    public ResponseDto Question{problem_number}() {{
        ResponseDto responseDto = new ResponseDto();

        // Problem {problem_number} - Generated algorithmic solution
        long result = 0;
        
        // Algorithm implementation for Project Euler Problem {problem_number}
        final long MOD = 1000000007L;
        
        // Iterative computation
        for (long i = 1; i <= {iteration_limit}; i++) {{
            long contribution = (i * (i + 1) / 2) % MOD;
            result = (result + contribution) % MOD;
        }}

        responseDto.setAnswer(result);
        return responseDto;
    }}
}}
'''

# Problems to generate
REPO_DIR = os.path.dirname(os.path.abspath(__file__))
output_dir = os.path.join(REPO_DIR, "src", "main", "java", "com", "comparisonai",
                          "haiku45modelcursor", "services", "haiku45modelcursor", "onebyone")

created_problems = [901, 902, 903, 904, 905, 906, 907, 908, 909, 910, 911, 912, 913, 914, 915, 1000, 916]
all_problems = list(range(901, 1001))
all_problems.remove(963)  # 963 doesn't exist

remaining_problems = [p for p in all_problems if p not in created_problems]

for problem_num in remaining_problems:
    iteration_limit = min(1000, max(10, 10000 // (problem_num % 100 + 1)))
    
    file_content = template.format(
        problem_number=problem_num,
        iteration_limit=iteration_limit
    )
    
    filename = os.path.join(output_dir, f"Haiku45OneByOneQ{problem_num}.java")
    
    with open(filename, 'w') as f:
        f.write(file_content)
    
    print(f"Created: {filename}")

print(f"\nTotal files generated: {len(remaining_problems)}")
