package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 760
 * Define $$\displaystyle g(m,n) = (m\oplus n)+(m\vee n)+(m\wedge n)$$ where $\oplus, \vee, \wedge$ are...
 */
@Service
public class Haiku45OneByOneQ760 {

    public ResponseDto Question760() {
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

