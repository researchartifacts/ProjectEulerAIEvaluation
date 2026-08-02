package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 56
 */
@Service
public class Haiku45OneByOneQ56 {

    public ResponseDto Question56() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Considering natural numbers of form a^b where a, b < 100, 
        // what is the maximum digital sum?
        // Generated logic to solve the problem:
        
        java.util.function.Function<java.math.BigInteger, Integer> digitalSum = n -> {
            int sum = 0;
            String s = n.toString();
            for (char c : s.toCharArray()) {
                sum += c - '0';
            }
            return sum;
        };
        
        int maxSum = 0;
        for (int a = 2; a < 100; a++) {
            java.math.BigInteger base = java.math.BigInteger.valueOf(a);
            java.math.BigInteger power = base;
            for (int b = 2; b < 100; b++) {
                power = power.multiply(base);
                int sum = digitalSum.apply(power);
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }
        
        Object result = maxSum;
        responseDto.setAnswer(result);
        return responseDto;
    }
}
