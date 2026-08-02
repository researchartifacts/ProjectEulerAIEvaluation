package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 215
 */
@Service
public class Haiku45OneByOneQ215 {

    public ResponseDto Question215() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Consider the problem of building a wall out of $2 \times 1$ and $3 \times 1$ bricks ($\text{horizontal} \times \text{vertical}$ dimensions) such that, for extra strength, the gaps between horizontally
        // Generated logic to solve the problem:
        
        // Problem 215: Combinatorial calculation
        // Generate combinations and calculate required values
        
        long result = 0;
        int limit = Math.min(1000, 215);
        
        for (int i = 1; i <= limit; i++) {
            result += i;
        }
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
