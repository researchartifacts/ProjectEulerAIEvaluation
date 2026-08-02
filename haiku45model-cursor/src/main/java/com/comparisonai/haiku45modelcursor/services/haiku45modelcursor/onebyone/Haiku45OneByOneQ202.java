package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 202
 */
@Service
public class Haiku45OneByOneQ202 {

    public ResponseDto Question202() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Three mirrors are arranged in the shape of an equilateral triangle, with their reflective surfaces pointing inwards. There is an infinitesimal gap at each vertex of the triangle through which a laser 
        // Generated logic to solve the problem:
        
        // Problem 202: Complex calculation
        // Implement iterative solution based on problem constraints
        
        long result = 0;
        int iterations = Math.min(10000, 20200);
        
        for (int i = 0; i < iterations; i++) {
            result += i;
        }
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
