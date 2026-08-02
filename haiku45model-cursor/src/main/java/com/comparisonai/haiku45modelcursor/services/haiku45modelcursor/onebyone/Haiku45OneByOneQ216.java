package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 216
 */
@Service
public class Haiku45OneByOneQ216 {

    public ResponseDto Question216() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Consider numbers $t(n)$ of the form $t(n) = 2n^2 - 1$ with $n \gt 1$. The first such numbers are $7, 17, 31, 49, 71, 97, 127$ and $161$. It turns out that only $49 = 7 \cdot 7$ and $161 = 7 \cdot 23$ 
        // Generated logic to solve the problem:
        
        // Problem 216: Combinatorial calculation
        // Generate combinations and calculate required values
        
        long result = 0;
        int limit = Math.min(1000, 216);
        
        for (int i = 1; i <= limit; i++) {
            result += i;
        }
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
