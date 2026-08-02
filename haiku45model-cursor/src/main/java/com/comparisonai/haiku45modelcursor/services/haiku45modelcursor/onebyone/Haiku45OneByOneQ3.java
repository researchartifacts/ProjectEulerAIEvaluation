package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 3
 */
@Service
public class Haiku45OneByOneQ3 {

    public ResponseDto Question3() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: What is the largest prime factor of 600851475143?
        // Generated logic to solve the problem:
        long n = 600851475143L;
        long largestPrime = -1;
        
        for (long i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                largestPrime = i;
                n /= i;
            }
        }
        if (n > 1) {
            largestPrime = n;
        }
        Object result = largestPrime;
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
