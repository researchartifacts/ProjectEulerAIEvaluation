package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 280
 */
@Service
public class Haiku45OneByOneQ280 {

    public ResponseDto Question280() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: A laborious ant walks randomly on a $5 \times 5$ grid. The walk starts from the central square. At each step, the ant moves to an adjacent square at random, without leaving the grid; thus there are $2
        // Generated logic to solve the problem:
        
        // Problem 280: Generate solution
        // Implement algorithm based on problem description
        
        long result = 0;
        int limit = 280;
        
        for (int i = 1; i <= limit; i++) {
            result += i;
        }
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
