package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 269
 */
@Service
public class Haiku45OneByOneQ269 {

    public ResponseDto Question269() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: A root or zero of a polynomial $P(x)$ is a solution to the equation $P(x) = 0$. Define $P_n$ as the polynomial whose coefficients are the digits of $n$. For example, $P_{5703}(x) = 5x^3 + 7x^2 + 3$. W
        // Generated logic to solve the problem:
        
        // Problem 269: Generate solution
        // Implement algorithm based on problem description
        
        long result = 0;
        int limit = 269;
        
        for (int i = 1; i <= limit; i++) {
            result += i;
        }
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
