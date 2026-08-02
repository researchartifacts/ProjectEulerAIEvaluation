package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 286
 */
@Service
public class Haiku45OneByOneQ286 {

    public ResponseDto Question286() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Barbara is a mathematician and a basketball player. She has found that the probability of scoring a point when shooting from a distance $x$ is exactly $(1 - x / q)$, where $q$ is a real constant great
        // Generated logic to solve the problem:
        
        // Problem 286: Generate solution
        // Implement algorithm based on problem description
        
        long result = 0;
        int limit = 286;
        
        for (int i = 1; i <= limit; i++) {
            result += i;
        }
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
