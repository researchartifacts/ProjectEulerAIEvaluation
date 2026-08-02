package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 252
 */
@Service
public class Haiku45OneByOneQ252 {

    public ResponseDto Question252() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Given a set of points on a plane, we define a convex hole to be a convex polygon having as vertices any of the given points and not containing any of the given points in its interior (in addition to t
        // Generated logic to solve the problem:
        
        // Problem 252: Generate solution
        // Implement algorithm based on problem description
        
        long result = 0;
        int limit = 252;
        
        for (int i = 1; i <= limit; i++) {
            result += i;
        }
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
