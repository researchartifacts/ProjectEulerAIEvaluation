package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 72
 */
@Service
public class Haiku45OneByOneQ72 {

    public ResponseDto Question72() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Count reduced proper fractions for d <= 1,000,000 using Euler's totient function
        // Generated logic to solve the problem:
        
        long count = 0;
        
        // For each denominator d, the number of reduced proper fractions with that denominator
        // equals Euler's totient function phi(d)
        for (long d = 2; d <= 1000000; d++) {
            count += computeTotient(d);
        }
        
        Object result = count;
        
        responseDto.setAnswer(result);
        return responseDto;
    }
    
    private long computeTotient(long n) {
        long result = n;
        long temp = n;
        
        for (long p = 2; p * p <= temp; p++) {
            if (temp % p == 0) {
                while (temp % p == 0) {
                    temp /= p;
                }
                result = result / p * (p - 1);
            }
        }
        
        if (temp > 1) {
            result = result / temp * (temp - 1);
        }
        
        return result;
    }
}
