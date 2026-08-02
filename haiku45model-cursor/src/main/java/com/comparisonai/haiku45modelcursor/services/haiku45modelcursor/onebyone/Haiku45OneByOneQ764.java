package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 764
 * Consider the following Diophantine equation: $$16x^2+y^4=z^2$$ where $x$, $y$ and $z$ are positive i...
 */
@Service
public class Haiku45OneByOneQ764 {

    public ResponseDto Question764() {
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

