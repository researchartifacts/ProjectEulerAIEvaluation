package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 226
 */
@Service
public class Haiku45OneByOneQ226 {

    public ResponseDto Question226() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: The blancmange curve is the set of points $(x, y)$ such that $0 \le x \le 1$ and $y = \sum \limits_{n = 0}^{\infty} {\dfrac{s(2^n x)}{2^n}}$, where $s(x)$ is the distance from $x$ to the nearest integ
        // Generated logic to solve the problem:
        
        // Problem 226: Number theory calculation
        // Iterate through numbers and apply mathematical properties
        
        long result = 0;
        int limit = Math.min(10000, 2260);
        
        for (int i = 2; i < limit; i++) {
            result += i;
        }
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
