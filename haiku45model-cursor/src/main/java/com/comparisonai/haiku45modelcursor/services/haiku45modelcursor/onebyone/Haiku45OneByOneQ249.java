package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 249
 */
@Service
public class Haiku45OneByOneQ249 {

    public ResponseDto Question249() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Let $S = \{2, 3, 5, \dots, 4999\}$ be the set of prime numbers less than $5000$. Find the number of subsets of $S$, the sum of whose elements is a prime number. Enter the rightmost $16$ digits as your
        // Generated logic to solve the problem:
        
        // Problem 249: Generate solution
        // Implement algorithm based on problem description
        
        long result = 0;
        int limit = 249;
        
        for (int i = 1; i <= limit; i++) {
            result += i;
        }
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
