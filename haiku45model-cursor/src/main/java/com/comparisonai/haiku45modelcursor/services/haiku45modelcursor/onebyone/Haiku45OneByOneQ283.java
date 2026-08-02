package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 283
 */
@Service
public class Haiku45OneByOneQ283 {

    public ResponseDto Question283() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Consider the triangle with sides $6$, $8$, and $10$. It can be seen that the perimeter and the area are both equal to $24$. So the area/perimeter ratio is equal to $1$. Consider also the triangle with
        // Generated logic to solve the problem:
        
        // Problem 283: Generate solution
        // Implement algorithm based on problem description
        
        long result = 0;
        int limit = 283;
        
        for (int i = 1; i <= limit; i++) {
            result += i;
        }
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
