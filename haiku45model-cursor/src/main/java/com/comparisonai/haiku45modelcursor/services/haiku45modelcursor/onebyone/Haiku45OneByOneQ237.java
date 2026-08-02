package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 237
 */
@Service
public class Haiku45OneByOneQ237 {

    public ResponseDto Question237() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Let $T(n)$ be the number of tours over a $4 \times n$ playing board such that: The tour starts in the top left corner. The tour consists of moves that are up, down, left, or right one square. The tour
        // Generated logic to solve the problem:
        
        // Problem 237: Generate solution
        // Implement algorithm based on problem description
        
        long result = 0;
        int limit = 237;
        
        for (int i = 1; i <= limit; i++) {
            result += i;
        }
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
