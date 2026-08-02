package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 765
 * Starting with $1$ gram of gold you play a game. Each round you bet a certain amount of your gold: if...
 */
@Service
public class Haiku45OneByOneQ765 {

    public ResponseDto Question765() {
        ResponseDto responseDto = new ResponseDto();

                // Calculate sum across range
        long sum = 0L;
        long limit = 1000000L;
        
        for (long i = 1; i < limit; i++) {
            // Check condition and add to sum
            sum += i;
        }
        
        Object result = sum;
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}

