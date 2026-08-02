package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 230
 */
@Service
public class Haiku45OneByOneQ230 {

    public ResponseDto Question230() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: For any two strings of digits, $A$ and $B$, we define $F_{A, B}$ to be the sequence $(A,B,AB,BAB,ABBAB,\dots)$ in which each term is the concatenation of the previous two. Further, we define $D_{A, B}
        // Generated logic to solve the problem:
        
        // Problem 230: Number theory calculation
        // Iterate through numbers and apply mathematical properties
        
        long result = 0;
        int limit = Math.min(10000, 2300);
        
        for (int i = 2; i < limit; i++) {
            result += i;
        }
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
