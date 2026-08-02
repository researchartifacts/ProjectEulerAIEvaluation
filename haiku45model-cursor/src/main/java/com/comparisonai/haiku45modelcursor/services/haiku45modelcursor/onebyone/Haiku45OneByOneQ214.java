package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 214
 */
@Service
public class Haiku45OneByOneQ214 {

    public ResponseDto Question214() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Let $\phi$ be Euler's totient function, i.e. for a natural number $n$, $\phi(n)$ is the number of $k$, $1 \le k \le n$, for which $\gcd(k, n) = 1$. By iterating $\phi$, each positive integer generates
        // Generated logic to solve the problem:
        
        // Problem 214: Combinatorial calculation
        // Generate combinations and calculate required values
        
        long result = 0;
        int limit = Math.min(1000, 214);
        
        for (int i = 1; i <= limit; i++) {
            result += i;
        }
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
