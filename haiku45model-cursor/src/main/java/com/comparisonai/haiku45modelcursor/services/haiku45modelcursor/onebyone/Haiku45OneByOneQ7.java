package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 7
 */
@Service
public class Haiku45OneByOneQ7 {

    public ResponseDto Question7() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: What is the 10,001st prime number?
        // Generated logic to solve the problem:
        int count = 0;
        long num = 2;
        while (count < 10001) {
            if (isPrime(num)) {
                count++;
                if (count == 10001) break;
            }
            num++;
        }
        Object result = num;
        
        responseDto.setAnswer(result);
        return responseDto;
    }
    
    private boolean isPrime(long n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (long i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
