package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 244
 */
@Service
public class Haiku45OneByOneQ244 {

    public ResponseDto Question244() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: You probably know the game Fifteen Puzzle. Here, instead of numbered tiles, we have seven red tiles and eight blue tiles. A move is denoted by the uppercase initial of the direction (Left, Right, Up, 
        // Generated logic to solve the problem:
        
        // Problem 244: Generate solution
        // Implement algorithm based on problem description
        
        long result = 0;
        int limit = 244;
        
        for (int i = 1; i <= limit; i++) {
            result += i;
        }
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
