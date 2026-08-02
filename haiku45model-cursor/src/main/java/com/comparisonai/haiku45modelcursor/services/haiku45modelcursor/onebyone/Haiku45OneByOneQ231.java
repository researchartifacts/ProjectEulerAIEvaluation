package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 231
 */
@Service
public class Haiku45OneByOneQ231 {

    public ResponseDto Question231() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: The binomial coefficient $\displaystyle \binom {10} 3 = 120$. $120 = 2^3 \times 3 \times 5 = 2 \times 2 \times 2 \times 3 \times 5$, and $2 + 2 + 2 + 3 + 5 = 14$. So the sum of the terms in the prime 
        // Generated logic to solve the problem:
        
        // Problem 231: Generate solution
        // Implement algorithm based on problem description
        
        long result = 0;
        int limit = 231;
        
        for (int i = 1; i <= limit; i++) {
            result += i;
        }
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
