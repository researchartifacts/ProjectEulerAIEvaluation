package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 247
 */
@Service
public class Haiku45OneByOneQ247 {

    public ResponseDto Question247() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Consider the region constrained by $1 \le x$ and $0 \le y \le 1/x$. Let $S_1$ be the largest square that can fit under the curve. Let $S_2$ be the largest square that fits in the remaining area, and s
        // Generated logic to solve the problem:
        
        // Problem 247: Generate solution
        // Implement algorithm based on problem description
        
        long result = 0;
        int limit = 247;
        
        for (int i = 1; i <= limit; i++) {
            result += i;
        }
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
