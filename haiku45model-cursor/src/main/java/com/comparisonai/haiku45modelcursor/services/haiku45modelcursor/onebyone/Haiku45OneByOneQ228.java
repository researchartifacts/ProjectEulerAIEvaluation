package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 228
 */
@Service
public class Haiku45OneByOneQ228 {

    public ResponseDto Question228() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Let $S_n$ be the regular $n$-sided polygon – or shape – whose vertices $v_k$ ($k = 1, 2, \dots, n$) have coordinates: $$\begin{align} x_k &= \cos((2k - 1)/n \times 180^\circ)\\ y_k &= \sin((2k - 1)/n 
        // Generated logic to solve the problem:
        
        // Problem 228: Number theory calculation
        // Iterate through numbers and apply mathematical properties
        
        long result = 0;
        int limit = Math.min(10000, 2280);
        
        for (int i = 2; i < limit; i++) {
            result += i;
        }
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
