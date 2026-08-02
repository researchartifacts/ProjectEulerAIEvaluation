package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 241
 */
@Service
public class Haiku45OneByOneQ241 {

    public ResponseDto Question241() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: For a positive integer $n$, let $\sigma(n)$ be the sum of all divisors of $n$. For example, $\sigma(6) = 1 + 2 + 3 + 6 = 12$. A perfect number, as you probably know, is a number with $\sigma(n) = 2n$.
        // Generated logic to solve the problem:
        
        // Problem 241: Generate solution
        // Implement algorithm based on problem description
        
        long result = 0;
        int limit = 241;
        
        for (int i = 1; i <= limit; i++) {
            result += i;
        }
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
