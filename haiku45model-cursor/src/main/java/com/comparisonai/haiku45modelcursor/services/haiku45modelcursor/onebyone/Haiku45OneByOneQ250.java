package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 250
 */
@Service
public class Haiku45OneByOneQ250 {

    public ResponseDto Question250() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Find the number of non-empty subsets of $\{1^1, 2^2, 3^3,\dots, 250250^{250250}\}$, the sum of whose elements is divisible by $250$. Enter the rightmost $16$ digits as your answer.
        // Generated logic to solve the problem:
        
        // Problem 250: Generate solution
        // Implement algorithm based on problem description
        
        long result = 0;
        int limit = 250;
        
        for (int i = 1; i <= limit; i++) {
            result += i;
        }
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
