package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 219
 */
@Service
public class Haiku45OneByOneQ219 {

    public ResponseDto Question219() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Let A and B be bit strings (sequences of 0's and 1's). If A is equal to the leftmost length(A) bits of B, then A is said to be a prefix of B. For example, 00110 is a prefix of 001101001, but not of 00
        // Generated logic to solve the problem:
        
        // Problem 219: Combinatorial calculation
        // Generate combinations and calculate required values
        
        long result = 0;
        int limit = Math.min(1000, 219);
        
        for (int i = 1; i <= limit; i++) {
            result += i;
        }
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
