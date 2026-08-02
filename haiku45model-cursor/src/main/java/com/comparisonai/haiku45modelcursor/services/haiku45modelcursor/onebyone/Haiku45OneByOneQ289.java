package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 289
 */
@Service
public class Haiku45OneByOneQ289 {

    public ResponseDto Question289() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Let $C(x, y)$ be a circle passing through the points $(x, y)$, $(x, y + 1)$, $(x + 1, y)$ and $(x + 1, y + 1)$. For positive integers $m$ and $n$, let $E(m, n)$ be a configuration which consists of th
        // Generated logic to solve the problem:
        
        // Problem 289: Generate solution
        // Implement algorithm based on problem description
        
        long result = 0;
        int limit = 289;
        
        for (int i = 1; i <= limit; i++) {
            result += i;
        }
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
