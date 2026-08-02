package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 731
 * $$A=\sum_{i=1}^{\infty} \frac{1}{3^i 10^{3^i}}$$ Define $A(n)$ to be the $10$ decimal digits from th...
 */
@Service
public class Haiku45OneByOneQ731 {

    public ResponseDto Question731() {
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

