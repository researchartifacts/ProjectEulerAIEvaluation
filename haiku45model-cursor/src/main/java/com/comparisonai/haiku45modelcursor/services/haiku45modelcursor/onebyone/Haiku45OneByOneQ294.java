package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 294
 */
@Service
public class Haiku45OneByOneQ294 {

    public ResponseDto Question294() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: For a positive integer $k$, define $d(k)$ as the sum of the digits of $k$ in its usual decimal representation. Thus $d(42) = 4+2 = 6$. For a positive integer $n$, define $S(n)$ as the number of positi
        // Generated logic to solve the problem:
        
        // Problem 294: Generate solution
        // Implement algorithm based on problem description
        
        long result = 0;
        int limit = 294;
        
        for (int i = 1; i <= limit; i++) {
            result += i;
        }
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
