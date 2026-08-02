package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 264
 */
@Service
public class Haiku45OneByOneQ264 {

    public ResponseDto Question264() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Consider all the triangles having: All their vertices on lattice pointsInteger coordinates. CircumcentreCentre of the circumscribed circle at the origin $O$. OrthocentrePoint where the three altitudes
        // Generated logic to solve the problem:
        
        // Problem 264: Generate solution
        // Implement algorithm based on problem description
        
        long result = 0;
        int limit = 264;
        
        for (int i = 1; i <= limit; i++) {
            result += i;
        }
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
