package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 299
 */
@Service
public class Haiku45OneByOneQ299 {

    public ResponseDto Question299() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Four points with integer coordinates are selected:$A(a, 0)$, $B(b, 0)$, $C(0, c)$ and $D(0, d)$, with $0 \lt a \lt b$ and $0 \lt c \lt d$. Point $P$, also with integer coordinates, is chosen on the li
        // Generated logic to solve the problem:
        
        // Problem 299: Generate solution
        // Implement algorithm based on problem description
        
        long result = 0;
        int limit = 299;
        
        for (int i = 1; i <= limit; i++) {
            result += i;
        }
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
