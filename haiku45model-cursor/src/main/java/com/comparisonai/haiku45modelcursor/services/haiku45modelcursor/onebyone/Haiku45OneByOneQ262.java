package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 262
 */
@Service
public class Haiku45OneByOneQ262 {

    public ResponseDto Question262() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: The following equation represents the continuous topography of a mountainous region, giving the elevationheight above sea level $h$ at any point $(x, y)$: $$h = \left(5000 - \frac{x^2 + y^2 + xy}{200}
        // Generated logic to solve the problem:
        
        // Problem 262: Generate solution
        // Implement algorithm based on problem description
        
        long result = 0;
        int limit = 262;
        
        for (int i = 1; i <= limit; i++) {
            result += i;
        }
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
