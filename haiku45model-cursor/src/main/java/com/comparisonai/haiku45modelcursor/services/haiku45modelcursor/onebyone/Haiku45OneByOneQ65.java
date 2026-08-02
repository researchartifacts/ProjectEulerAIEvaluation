package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 65
 */
@Service
public class Haiku45OneByOneQ65 {

    public ResponseDto Question65() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: The square root of 2 can be written as an infinite continued fraction. \sqrt{...
        // Generated logic to solve the problem:
        
        // Continued fraction for e: [2; 1, 2, 1, 1, 4, 1, 1, 6, 1, ..., 1, 2k, 1, ...]
        // Build the continued fraction coefficients
        java.util.List<Integer> cfE = new java.util.ArrayList<>();
        cfE.add(2);
        
        for (int k = 1; k <= 33; k++) {
            cfE.add(1);
            cfE.add(2 * k);
            cfE.add(1);
        }
        
        // Calculate convergents: h_n / k_n
        // h_n = a_n * h_(n-1) + h_(n-2)
        // k_n = a_n * k_(n-1) + k_(n-2)
        
        java.math.BigInteger h_prev2 = java.math.BigInteger.ONE;
        java.math.BigInteger h_prev1 = java.math.BigInteger.valueOf(cfE.get(0));
        
        for (int i = 1; i < 100; i++) {
            int a = cfE.get(i);
            java.math.BigInteger h_curr = java.math.BigInteger.valueOf(a).multiply(h_prev1).add(h_prev2);
            h_prev2 = h_prev1;
            h_prev1 = h_curr;
        }
        
        // Sum digits of numerator
        java.math.BigInteger numerator = h_prev1;
        long digitSum = 0;
        for (char c : numerator.toString().toCharArray()) {
            digitSum += Character.getNumericValue(c);
        }
        
        Object result = digitSum;
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
