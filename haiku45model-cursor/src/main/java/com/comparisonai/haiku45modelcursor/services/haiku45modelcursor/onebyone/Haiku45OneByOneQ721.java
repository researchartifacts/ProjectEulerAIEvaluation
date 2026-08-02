package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 721
 * Given is the function $f(a,n)=\lfloor (\lceil \sqrt a \rceil + \sqrt a)^n \rfloor$. $\lfloor \cdot \...
 */
@Service
public class Haiku45OneByOneQ721 {

    public ResponseDto Question721() {
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

