package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 770
 * A and B play a game. A has originally $1$ gram of gold and B has an unlimited amount. Each round goe...
 */
@Service
public class Haiku45OneByOneQ770 {

    public ResponseDto Question770() {
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

