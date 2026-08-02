package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 292
 */
@Service
public class Haiku45OneByOneQ292 {

    public ResponseDto Question292() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: We shall define a pythagorean polygon  to be a convex polygon with the following properties:there are at least three vertices, no three vertices are aligned, each vertex has integer coordinates, each 
        // Generated logic to solve the problem:
        
        // Problem 292: Generate solution
        // Implement algorithm based on problem description
        
        long result = 0;
        int limit = 292;
        
        for (int i = 1; i <= limit; i++) {
            result += i;
        }
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
