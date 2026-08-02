package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 5
 */
@Service
public class Haiku45OneByOneQ5 {

    public ResponseDto Question5() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Find the smallest positive number evenly divisible by all numbers from 1 to 20
        // Generated logic to solve the problem:
        long lcm = 1;
        for (int i = 1; i <= 20; i++) {
            lcm = lcm(lcm, i);
        }
        Object result = lcm;
        
        responseDto.setAnswer(result);
        return responseDto;
    }
    
    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
    
    private long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }
}
