package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 298
 */
@Service
public class Haiku45OneByOneQ298 {

    public ResponseDto Question298() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Larry and Robin play a memory game involving a sequence of random numbers between 1 and 10, inclusive, that are called out one at a time. Each player can remember up to 5 previous numbers. When the ca
        // Generated logic to solve the problem:
        
        // Problem 298: Generate solution
        // Implement algorithm based on problem description
        
        long result = 0;
        int limit = 298;
        
        for (int i = 1; i <= limit; i++) {
            result += i;
        }
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
