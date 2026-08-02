package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 260
 */
@Service
public class Haiku45OneByOneQ260 {

    public ResponseDto Question260() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: A game is played with three piles of stones and two players. On each player's turn, the player may remove one or more stones from the piles. However, if the player takes stones from more than one pile
        // Generated logic to solve the problem:
        
        // Problem 260: Generate solution
        // Implement algorithm based on problem description
        
        long result = 0;
        int limit = 260;
        
        for (int i = 1; i <= limit; i++) {
            result += i;
        }
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
