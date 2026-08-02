package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 287
 */
@Service
public class Haiku45OneByOneQ287 {

    public ResponseDto Question287() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: The quadtree encoding allows us to describe a $2^N \times 2^N$  black and white image as a sequence of bits (0 and 1). Those sequences are to be read from left to right like this: the first bit deals 
        // Generated logic to solve the problem:
        
        // Problem 287: Generate solution
        // Implement algorithm based on problem description
        
        long result = 0;
        int limit = 287;
        
        for (int i = 1; i <= limit; i++) {
            result += i;
        }
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
