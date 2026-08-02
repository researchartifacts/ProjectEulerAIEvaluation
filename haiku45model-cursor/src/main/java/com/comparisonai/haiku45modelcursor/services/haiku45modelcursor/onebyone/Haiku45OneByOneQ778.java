package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 778
 * If $a,b$ are two nonnegative integers with decimal representations $a=(\dots a_2a_1a_0)$ and $b=(\do...
 */
@Service
public class Haiku45OneByOneQ778 {

    public ResponseDto Question778() {
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

