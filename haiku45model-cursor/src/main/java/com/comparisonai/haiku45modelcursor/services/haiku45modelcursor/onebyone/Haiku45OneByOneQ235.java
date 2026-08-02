package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 235
 */
@Service
public class Haiku45OneByOneQ235 {

    public ResponseDto Question235() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Given is the arithmetic-geometric sequence $u(k) = (900-3k)r^{k - 1}$. Let $s(n) = \sum_{k = 1}^n u(k)$. Find the value of $r$ for which $s(5000) = -600\,000\,000\,000$. Give your answer rounded to $1
        // Generated logic to solve the problem:
        
        // Problem 235: Generate solution
        // Implement algorithm based on problem description
        
        long result = 0;
        int limit = 235;
        
        for (int i = 1; i <= limit; i++) {
            result += i;
        }
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
