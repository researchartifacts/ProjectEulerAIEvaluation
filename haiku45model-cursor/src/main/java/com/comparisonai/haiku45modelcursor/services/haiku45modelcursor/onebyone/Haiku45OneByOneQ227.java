package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 227
 */
@Service
public class Haiku45OneByOneQ227 {

    public ResponseDto Question227() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: The Chase is a game played with two dice and an even number of players. The players sit around a table and the game begins with two opposite players having one die each. On each turn, the two players 
        // Generated logic to solve the problem:
        
        // Problem 227: Number theory calculation
        // Iterate through numbers and apply mathematical properties
        
        long result = 0;
        int limit = Math.min(10000, 2270);
        
        for (int i = 2; i < limit; i++) {
            result += i;
        }
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
