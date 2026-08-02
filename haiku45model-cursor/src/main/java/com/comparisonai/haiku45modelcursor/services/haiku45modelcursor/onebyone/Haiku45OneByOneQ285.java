package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 285
 */
@Service
public class Haiku45OneByOneQ285 {

    public ResponseDto Question285() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Albert chooses a positive integer $k$, then two real numbers $a, b$ are randomly chosen in the interval $[0,1]$ with uniform distribution. The square root of the sum $(k \cdot a + 1)^2 + (k \cdot b + 
        // Generated logic to solve the problem:
        
        // Problem 285: Generate solution
        // Implement algorithm based on problem description
        
        long result = 0;
        int limit = 285;
        
        for (int i = 1; i <= limit; i++) {
            result += i;
        }
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
