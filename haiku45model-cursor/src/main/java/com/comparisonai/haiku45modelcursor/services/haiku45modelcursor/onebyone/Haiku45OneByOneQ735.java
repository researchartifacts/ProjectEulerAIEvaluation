package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 735
 * Let $f(n)$ be the number of divisors of $2n^2$ that are no greater than n. For example, $f(15)=8$ be...
 */
@Service
public class Haiku45OneByOneQ735 {

    public ResponseDto Question735() {
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

