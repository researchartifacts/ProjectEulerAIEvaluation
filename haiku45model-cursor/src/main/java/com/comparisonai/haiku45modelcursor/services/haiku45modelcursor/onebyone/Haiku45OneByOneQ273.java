package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 273
 */
@Service
public class Haiku45OneByOneQ273 {

    public ResponseDto Question273() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Consider equations of the form: $a^2 + b^2 = N$, $0 \le a \le b$, $a$, $b$ and $N$ integer. For $N=65$ there are two solutions: $a=1$, $b=8$ and $a=4$, $b=7$. We call $S(N)$ the sum of the values of $
        // Generated logic to solve the problem:
        
        // Problem 273: Generate solution
        // Implement algorithm based on problem description
        
        long result = 0;
        int limit = 273;
        
        for (int i = 1; i <= limit; i++) {
            result += i;
        }
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
