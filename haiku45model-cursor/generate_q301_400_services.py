#!/usr/bin/env python3
"""
Generate individual Spring Boot service files for Project Euler problems 301-400
using Claude Haiku 4.5 model.
"""

import os
import json
import re
from pathlib import Path
import anthropic

# Initialize Anthropic client
client = anthropic.Anthropic()

# Configuration
PROBLEMS_DIR = "problems/301to400"
OUTPUT_DIR = "src/main/java/com/comparisonai/haiku45modelcursor/services/haiku45modelcursor/onebyone"
PACKAGE_NAME = "com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone"

def clean_html(text):
    """Remove HTML tags from problem description"""
    # Remove HTML tags
    text = re.sub(r'<[^>]+>', '', text)
    # Decode common HTML entities
    text = text.replace('&nbsp;', ' ')
    text = text.replace('&lt;', '<')
    text = text.replace('&gt;', '>')
    text = text.replace('&quot;', '"')
    text = text.replace('&amp;', '&')
    # Remove math notation for simplicity
    text = re.sub(r'\$[^$]*\$', '', text)
    text = re.sub(r'&dfn;', '')
    text = re.sub(r'</dfn>', '')
    text = re.sub(r'<sup>[^<]*</sup>', '')
    text = re.sub(r'<[^>]+>', '', text)
    # Clean up whitespace
    text = ' '.join(text.split())
    return text[:500]  # Truncate to 500 chars

def read_problem(problem_num):
    """Read problem description from file"""
    problem_file = os.path.join(PROBLEMS_DIR, f"{problem_num}.txt")
    if not os.path.exists(problem_file):
        return None
    
    with open(problem_file, 'r', encoding='utf-8') as f:
        content = f.read()
    
    return clean_html(content)

def generate_solution(problem_num, problem_description):
    """Generate Java solution code using Claude Haiku"""
    
    prompt = f"""You are a Java developer generating solutions for Project Euler problems.

Problem {problem_num}: {problem_description}

Generate ONLY the Java code logic (no comments) to solve this problem. The logic should:
1. Use efficient algorithms
2. Avoid any pre-calculated or hardcoded answers
3. Be suitable for a ResponseDto where the result is set as an Object

The method signature is:
public ResponseDto question{problem_num}() {{
    ResponseDto responseDto = new ResponseDto();
    long startTime = System.currentTimeMillis();
    
    // GENERATE LOGIC HERE
    Object result = /* your calculated result */;
    
    responseDto.setAnswer(result);
    responseDto.setTime(System.currentTimeMillis() - startTime);
    return responseDto;
}}

Provide ONLY the Java code logic that goes between "// GENERATE LOGIC HERE" and "Object result = ..." 
Include necessary variable declarations, loops, algorithms, etc.
Do NOT include the method signature or ResponseDto setup.
Do NOT include comments explaining the logic.
Start with variable declarations and calculations."""

    try:
        message = client.messages.create(
            model="claude-3-5-haiku-20241022",
            max_tokens=1024,
            messages=[
                {"role": "user", "content": prompt}
            ]
        )
        
        code = message.content[0].text
        return code.strip()
    except Exception as e:
        print(f"Error generating solution for problem {problem_num}: {e}")
        return ""

def create_service_file(problem_num, logic_code):
    """Create individual Spring Boot service file for a problem"""
    
    method_name = f"question{problem_num}"
    class_name = f"Haiku45OneByOneQ{problem_num}"
    
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
        
        Object result = /* calculated result */;
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
    
    print(f"✓ Generated {output_file}")
    return output_file

def main():
    """Main execution function"""
    
    print(f"Starting generation of Project Euler 301-400 solutions...")
    print(f"Output directory: {OUTPUT_DIR}")
    print()
    
    total_problems = 100
    generated_count = 0
    
    for problem_num in range(301, 401):
        print(f"Processing Problem {problem_num}/{total_problems}...", end=" ", flush=True)
        
        # Read problem description
        problem_desc = read_problem(problem_num)
        if not problem_desc:
            print(f"✗ Problem file not found")
            continue
        
        # Generate solution
        logic_code = generate_solution(problem_num, problem_desc)
        if not logic_code:
            print(f"✗ Failed to generate solution")
            continue
        
        # Create service file
        try:
            create_service_file(problem_num, logic_code)
            generated_count += 1
        except Exception as e:
            print(f"✗ Error creating file: {e}")
    
    print()
    print(f"Generation complete! Generated {generated_count}/{total_problems} service files.")

if __name__ == "__main__":
    main()
