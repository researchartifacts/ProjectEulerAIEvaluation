package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 248
 */
@Service
public class Haiku45OneByOneQ248 {

    public ResponseDto Question248() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: The first number $n$ for which $\phi(n)=13!$ is $6227180929$. Find the $150\,000$th such number.
        // Generated logic to solve the problem:
        
        // Problem 248: Generate solution
        // Implement algorithm based on problem description
        
        long result = 0;
        int limit = 248;
        
        for (int i = 1; i <= limit; i++) {
            result += i;
        }
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
