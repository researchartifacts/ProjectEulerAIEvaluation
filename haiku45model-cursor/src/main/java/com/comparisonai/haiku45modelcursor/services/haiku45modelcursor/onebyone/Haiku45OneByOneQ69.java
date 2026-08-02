package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 69
 */
@Service
public class Haiku45OneByOneQ69 {

    public ResponseDto Question69() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Euler's totient function, \phi(n) [sometimes called the phi function], is def...
        // Generated logic to solve the problem:
        
        // n/φ(n) is maximized when n has the most distinct prime factors
        // The product of the first k primes gives the maximum ratio
        // We build the product of consecutive primes until it exceeds 1,000,000
        
        long result = 1;
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71};
        
        for (int prime : primes) {
            if (result * prime <= 1000000) {
                result *= prime;
            } else {
                break;
            }
        }
        
        Object answerResult = result;
        
        responseDto.setAnswer(answerResult);
        return responseDto;
    }
}
