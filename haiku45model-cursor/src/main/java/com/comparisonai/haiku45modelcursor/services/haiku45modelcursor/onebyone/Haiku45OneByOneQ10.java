package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 10
 */
@Service
public class Haiku45OneByOneQ10 {

    public ResponseDto Question10() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Find the sum of all primes below two million
        // Generated logic to solve the problem:
        long sum = 0;
        int limit = 2000000;
        boolean[] isPrime = new boolean[limit];
        for (int i = 2; i < limit; i++) {
            isPrime[i] = true;
        }
        
        for (int i = 2; i * i < limit; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < limit; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        
        for (int i = 2; i < limit; i++) {
            if (isPrime[i]) {
                sum += i;
            }
        }
        Object result = sum;
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
