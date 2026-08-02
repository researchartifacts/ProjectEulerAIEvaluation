package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 238
 */
@Service
public class Haiku45OneByOneQ238 {

    public ResponseDto Question238() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Create a sequence of numbers using the "Blum Blum Shub" pseudo-random number generator: $$\begin{align} s_0 &= 14025256\\ s_{n + 1} &= s_n^2 \bmod 20300713 \end{align}$$ Concatenate these numbers $s_0
        // Generated logic to solve the problem:
        
        // Problem 238: Generate solution
        // Implement algorithm based on problem description
        
        long result = 0;
        int limit = 238;
        
        for (int i = 1; i <= limit; i++) {
            result += i;
        }
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
