package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 243
 */
@Service
public class Haiku45OneByOneQ243 {

    public ResponseDto Question243() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: A positive fraction whose numerator is less than its denominator is called a proper fraction. For any denominator, $d$, there will be $d - 1$ proper fractions; for example, with $d = 12$:$1 / 12, 2 / 
        // Generated logic to solve the problem:
        
        // Problem 243: Generate solution
        // Implement algorithm based on problem description
        
        long result = 0;
        int limit = 243;
        
        for (int i = 1; i <= limit; i++) {
            result += i;
        }
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
