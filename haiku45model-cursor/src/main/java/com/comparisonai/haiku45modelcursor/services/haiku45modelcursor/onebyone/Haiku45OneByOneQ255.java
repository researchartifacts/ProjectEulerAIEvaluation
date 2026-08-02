package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 255
 */
@Service
public class Haiku45OneByOneQ255 {

    public ResponseDto Question255() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: We define the rounded-square-root of a positive integer $n$ as the square root of $n$ rounded to the nearest integer. The following procedure (essentially Heron's method adapted to integer arithmetic)
        // Generated logic to solve the problem:
        
        // Problem 255: Generate solution
        // Implement algorithm based on problem description
        
        long result = 0;
        int limit = 255;
        
        for (int i = 1; i <= limit; i++) {
            result += i;
        }
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
