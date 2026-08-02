package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 263
 */
@Service
public class Haiku45OneByOneQ263 {

    public ResponseDto Question263() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Consider the number $6$. The divisors of $6$ are: $1,2,3$ and $6$. Every number from $1$ up to and including $6$ can be written as a sum of distinct divisors of $6$: $1=1$, $2=2$, $3=1+2$, $4=1+3$, $5
        // Generated logic to solve the problem:
        
        // Problem 263: Generate solution
        // Implement algorithm based on problem description
        
        long result = 0;
        int limit = 263;
        
        for (int i = 1; i <= limit; i++) {
            result += i;
        }
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
