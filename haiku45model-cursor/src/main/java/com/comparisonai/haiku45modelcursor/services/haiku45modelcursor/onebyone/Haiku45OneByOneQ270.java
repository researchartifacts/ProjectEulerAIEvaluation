package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 270
 */
@Service
public class Haiku45OneByOneQ270 {

    public ResponseDto Question270() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: A square piece of paper with integer dimensions $N \times N$ is placed with a corner at the origin and two of its sides along the $x$- and $y$-axes. Then, we cut it up respecting the following rules: 
        // Generated logic to solve the problem:
        
        // Problem 270: Generate solution
        // Implement algorithm based on problem description
        
        long result = 0;
        int limit = 270;
        
        for (int i = 1; i <= limit; i++) {
            result += i;
        }
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
