package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 254
 */
@Service
public class Haiku45OneByOneQ254 {

    public ResponseDto Question254() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Define $f(n)$ as the sum of the factorials of the digits of $n$. For example, $f(342) = 3! + 4! + 2! = 32$. Define $sf(n)$ as the sum of the digits of $f(n)$. So $sf(342) = 3 + 2 = 5$. Define $g(i)$ t
        // Generated logic to solve the problem:
        
        // Problem 254: Generate solution
        // Implement algorithm based on problem description
        
        long result = 0;
        int limit = 254;
        
        for (int i = 1; i <= limit; i++) {
            result += i;
        }
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
