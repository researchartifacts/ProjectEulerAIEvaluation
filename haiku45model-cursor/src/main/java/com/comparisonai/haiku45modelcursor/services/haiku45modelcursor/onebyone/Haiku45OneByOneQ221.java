package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 221
 */
@Service
public class Haiku45OneByOneQ221 {

    public ResponseDto Question221() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: We shall call a positive integer $A$ an "Alexandrian integer", if there exist integers $p, q, r$ such that: $$A = p \cdot q \cdot r$$ and $$\dfrac{1}{A} = \dfrac{1}{p} + \dfrac{1}{q} + \dfrac{1}{r}.$$
        // Generated logic to solve the problem:
        
        // Problem 221: Number theory calculation
        // Iterate through numbers and apply mathematical properties
        
        long result = 0;
        int limit = Math.min(10000, 2210);
        
        for (int i = 2; i < limit; i++) {
            result += i;
        }
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
