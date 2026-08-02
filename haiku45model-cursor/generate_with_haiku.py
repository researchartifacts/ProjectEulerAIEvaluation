#!/usr/bin/env python3
"""
Generate Project Euler 301-400 solutions using Claude Haiku 4.5
"""

import os
import re
import json
from pathlib import Path

try:
    import anthropic
except ImportError:
    print("anthropic package not found. Install with: pip install anthropic")
    exit(1)

# Configuration
PROBLEMS_DIR = "problems/301to400"
OUTPUT_DIR = "src/main/java/com/comparisonai/haiku45modelcursor/services/haiku45modelcursor/onebyone"
PACKAGE_NAME = "com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone"
MODEL = "claude-3-5-haiku-20241022"

client = anthropic.Anthropic()

def clean_html(text):
    """Remove HTML tags from problem description"""
    text = re.sub(r'<[^>]+>', '', text)
    text = text.replace('&nbsp;', ' ')
    text = text.replace('&lt;', '<')
    text = text.replace('&gt;', '>')
    text = text.replace('&quot;', '"')
    text = text.replace('&amp;', '&')
    text = re.sub(r'\$[^$]*\$', '', text)
    text = ' '.join(text.split())
    return text[:500]

def read_problem(problem_num):
    """Read problem description from file"""
    problem_file = os.path.join(PROBLEMS_DIR, f"{problem_num}.txt")
    if not os.path.exists(problem_file):
        return None
    
    with open(problem_file, 'r', encoding='utf-8') as f:
        content = f.read()
    
    return clean_html(content)

def generate_solution_logic(problem_num, description):
    """Generate Java solution logic using Claude Haiku"""
    
    prompt = f"""You are a competitive programmer solving Project Euler problems in Java.

Problem {problem_num}:
{description}

Your task is to write ONLY the algorithm implementation code in Java that will solve this problem.

Requirements:
1. Do NOT include any comments
2. Do NOT include method signature or class definition
3. Do NOT hardcode any known answers
4. The code should calculate the result from scratch
5. The result should be assigned to a variable called 'result'
6. Use efficient algorithms appropriate for the problem
7. Import statements should be added as needed in comments at the top

Format your response as pure Java code that can be inserted into this method:
public ResponseDto Question{problem_num}() {{
    ResponseDto responseDto = new ResponseDto();
    long startTime = System.currentTimeMillis();
    
    [YOUR CODE HERE]
    
    responseDto.setAnswer(result);
    responseDto.setTime(System.currentTimeMillis() - startTime);
    return responseDto;
}}

Provide ONLY executable Java code with no explanations."""

    try:
        message = client.messages.create(
            model=MODEL,
            max_tokens=1500,
            messages=[
                {"role": "user", "content": prompt}
            ]
        )
        
        code = message.content[0].text.strip()
        
        # Clean up code if it contains markdown code blocks
        if code.startswith('```'):
            code = re.sub(r'^```(?:java)?\\n', '', code)
            code = re.sub(r'\\n```$', '', code)
        
        return code
    except Exception as e:
        print(f"Error generating solution for problem {problem_num}: {e}")
        return None

def create_service_file(problem_num, logic_code):
    """Create individual Spring Boot service file"""
    
    class_name = f"Haiku45OneByOneQ{problem_num}"
    method_name = f"Question{problem_num}"
    
    java_code = f"""package {PACKAGE_NAME};

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;
import java.math.*;
import java.util.stream.*;

/**
 * Problem {problem_num}
 */
@Service
public class {class_name} {{

    public ResponseDto {method_name}() {{
        ResponseDto responseDto = new ResponseDto();
        long startTime = System.currentTimeMillis();

        {logic_code}

        responseDto.setAnswer(result);
        responseDto.setTime(System.currentTimeMillis() - startTime);
        return responseDto;
    }}
}}
"""
    
    # Create output directory if it doesn't exist
    os.makedirs(OUTPUT_DIR, exist_ok=True)
    
    # Write file
    output_file = os.path.join(OUTPUT_DIR, f"{class_name}.java")
    with open(output_file, 'w', encoding='utf-8') as f:
        f.write(java_code)
    
    return output_file

def main():
    """Main execution"""
    
    print("Generating Project Euler 301-400 solutions with Claude Haiku 4.5")
    print(f"Output: {OUTPUT_DIR}")
    print(f"Model: {MODEL}")
    print()
    
    generated = 0
    failed = 0
    
    for problem_num in range(301, 401):
        print(f"Problem {problem_num}: ", end="", flush=True)
        
        # Read problem
        desc = read_problem(problem_num)
        if not desc:
            print("✗ (problem file not found)")
            failed += 1
            continue
        
        # Generate solution
        logic = generate_solution_logic(problem_num, desc)
        if not logic:
            print("✗ (generation failed)")
            failed += 1
            continue
        
        # Create file
        try:
            output_file = create_service_file(problem_num, logic)
            print(f"✓ ({os.path.basename(output_file)})")
            generated += 1
        except Exception as e:
            print(f"✗ ({str(e)})")
            failed += 1
    
    print()
    print(f"Complete: {generated} generated, {failed} failed")

if __name__ == "__main__":
    main()
