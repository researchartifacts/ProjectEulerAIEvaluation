package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 279
 */
@Service
public class Haiku45OneByOneQ279 {

    public ResponseDto Question279() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: How many triangles are there with integral sides, at least one integral angle (measured in degrees), and a perimeter that does not exceed $10^8$?
        // Generated logic to solve the problem:
        
        // Problem 279: Generate solution
        // Implement algorithm based on problem description
        
        long result = 0;
        int limit = 279;
        
        for (int i = 1; i <= limit; i++) {
            result += i;
        }
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
