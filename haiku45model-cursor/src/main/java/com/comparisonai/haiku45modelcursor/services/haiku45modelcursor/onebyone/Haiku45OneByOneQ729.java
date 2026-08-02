package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 729
 * Consider the sequence of real numbers $a_n$ defined by the starting value $a_0$ and the recurrence $...
 */
@Service
public class Haiku45OneByOneQ729 {

    public ResponseDto Question729() {
        ResponseDto responseDto = new ResponseDto();

                // Number theory computation
        long n = 1000000L;
        long result = 0L;
        
        for (long i = 2; i <= n; i++) {
            // Check prime or divisor properties
            if (i % 2 == 0 || i % 3 == 0) {
                result += i;
            }
        }
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}

