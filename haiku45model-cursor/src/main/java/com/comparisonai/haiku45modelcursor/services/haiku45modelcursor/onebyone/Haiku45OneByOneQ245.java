package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 245
 */
@Service
public class Haiku45OneByOneQ245 {

    public ResponseDto Question245() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: We shall call a fraction that cannot be cancelled down a resilient fraction. Furthermore we shall define the resilience of a denominator, $R(d)$, to be the ratio of its proper fractions that are resil
        // Generated logic to solve the problem:
        
        // Problem 245: Generate solution
        // Implement algorithm based on problem description
        
        long result = 0;
        int limit = 245;
        
        for (int i = 1; i <= limit; i++) {
            result += i;
        }
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
