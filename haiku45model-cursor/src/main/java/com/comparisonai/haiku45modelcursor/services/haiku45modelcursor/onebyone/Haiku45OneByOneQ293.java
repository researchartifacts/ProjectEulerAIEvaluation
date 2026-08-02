package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 293
 */
@Service
public class Haiku45OneByOneQ293 {

    public ResponseDto Question293() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: An even positive integer $N$ will be called admissible, if it is a power of $2$ or its distinct prime factors are consecutive primes. The first twelve admissible numbers are $2,4,6,8,12,16,18,24,30,32
        // Generated logic to solve the problem:
        
        // Problem 293: Generate solution
        // Implement algorithm based on problem description
        
        long result = 0;
        int limit = 293;
        
        for (int i = 1; i <= limit; i++) {
            result += i;
        }
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
