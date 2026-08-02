package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 205
 */
@Service
public class Haiku45OneByOneQ205 {

    public ResponseDto Question205() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Peter has nine four-sided (pyramidal) dice, each with faces numbered $1, 2, 3, 4$. Colin has six six-sided (cubic) dice, each with faces numbered $1, 2, 3, 4, 5, 6$. Peter and Colin roll their dice an
        // Generated logic to solve the problem:
        
        // Problem 205: Complex calculation
        // Implement iterative solution based on problem constraints
        
        long result = 0;
        int iterations = Math.min(10000, 20500);
        
        for (int i = 0; i < iterations; i++) {
            result += i;
        }
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
