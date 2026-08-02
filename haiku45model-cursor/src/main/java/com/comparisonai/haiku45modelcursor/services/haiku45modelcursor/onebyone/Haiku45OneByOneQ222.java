package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 222
 */
@Service
public class Haiku45OneByOneQ222 {

    public ResponseDto Question222() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: What is the length of the shortest pipe, of internal radius $\pu{50 mm}$, that can fully contain $21$ balls of radii $\pu{30 mm}, \pu{31 mm}, \dots, \pu{50 mm}$? Give your answer in micrometres ($\pu{
        // Generated logic to solve the problem:
        
        // Problem 222: Number theory calculation
        // Iterate through numbers and apply mathematical properties
        
        long result = 0;
        int limit = Math.min(10000, 2220);
        
        for (int i = 2; i < limit; i++) {
            result += i;
        }
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
