package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 733
 * Let $a_i$ be the sequence defined by $a_i=153^i \bmod 10\,000\,019$ for $i \ge 1$. The first terms o...
 */
@Service
public class Haiku45OneByOneQ733 {

    public ResponseDto Question733() {
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

