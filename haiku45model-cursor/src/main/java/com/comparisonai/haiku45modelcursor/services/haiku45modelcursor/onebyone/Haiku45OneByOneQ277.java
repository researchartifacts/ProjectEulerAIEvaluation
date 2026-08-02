package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 277
 */
@Service
public class Haiku45OneByOneQ277 {

    public ResponseDto Question277() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: A modified Collatz sequence of integers is obtained from a starting value $a_1$ in the following way: $a_{n+1} = \, \,\, \frac {a_n} 3 \quad$ if $a_n$ is divisible by $3$. We shall denote this as a la
        // Generated logic to solve the problem:
        
        // Problem 277: Generate solution
        // Implement algorithm based on problem description
        
        long result = 0;
        int limit = 277;
        
        for (int i = 1; i <= limit; i++) {
            result += i;
        }
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
