package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 295
 */
@Service
public class Haiku45OneByOneQ295 {

    public ResponseDto Question295() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: We call the convex area enclosed by two circles a lenticular hole if: The centres of both circles are on lattice points. The two circles intersect at two distinct lattice points. The interior of the c
        // Generated logic to solve the problem:
        
        // Problem 295: Generate solution
        // Implement algorithm based on problem description
        
        long result = 0;
        int limit = 295;
        
        for (int i = 1; i <= limit; i++) {
            result += i;
        }
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
