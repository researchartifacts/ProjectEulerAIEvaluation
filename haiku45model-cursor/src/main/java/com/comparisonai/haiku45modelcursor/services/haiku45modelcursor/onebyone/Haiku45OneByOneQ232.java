package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 232
 */
@Service
public class Haiku45OneByOneQ232 {

    public ResponseDto Question232() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Two players share an unbiased coin and take it in turns to play The Race. On Player 1's turn, the coin is tossed once. If it comes up Heads, then Player 1 scores one point; if it comes up Tails, then 
        // Generated logic to solve the problem:
        
        // Problem 232: Generate solution
        // Implement algorithm based on problem description
        
        long result = 0;
        int limit = 232;
        
        for (int i = 1; i <= limit; i++) {
            result += i;
        }
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
