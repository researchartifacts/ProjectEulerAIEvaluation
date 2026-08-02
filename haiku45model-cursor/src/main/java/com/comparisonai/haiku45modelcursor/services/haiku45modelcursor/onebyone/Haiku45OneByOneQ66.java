package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 66
 */
@Service
public class Haiku45OneByOneQ66 {

    public ResponseDto Question66() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Consider quadratic Diophantine equations of the form: x^2 - Dy^2 = 1 For exam...
        // Generated logic to solve the problem:
        
        long maxX = 0;
        int resultD = 0;
        
        for (int D = 1; D <= 1000; D++) {
            // Skip perfect squares
            int sqrtD = (int) Math.sqrt(D);
            if (sqrtD * sqrtD == D) {
                continue;
            }
            
            // Find minimal solution to x^2 - D*y^2 = 1 using continued fractions
            long x = findMinimalSolution(D);
            
            if (x > maxX) {
                maxX = x;
                resultD = D;
            }
        }
        
        Object result = resultD;
        
        responseDto.setAnswer(result);
        return responseDto;
    }
    
    private long findMinimalSolution(int D) {
        int a0 = (int) Math.sqrt(D);
        int m = 0;
        int d = 1;
        int a = a0;
        
        java.math.BigInteger h_prev2 = java.math.BigInteger.ONE;
        java.math.BigInteger h_prev1 = java.math.BigInteger.valueOf(a0);
        java.math.BigInteger k_prev2 = java.math.BigInteger.ZERO;
        java.math.BigInteger k_prev1 = java.math.BigInteger.ONE;
        
        while (true) {
            m = d * a - m;
            d = (D - m * m) / d;
            a = (a0 + m) / d;
            
            java.math.BigInteger h_curr = java.math.BigInteger.valueOf(a).multiply(h_prev1).add(h_prev2);
            java.math.BigInteger k_curr = java.math.BigInteger.valueOf(a).multiply(k_prev1).add(k_prev2);
            
            java.math.BigInteger xSquaredMinusDySquared = h_curr.multiply(h_curr)
                .subtract(java.math.BigInteger.valueOf(D).multiply(k_curr.multiply(k_curr)));
            
            if (xSquaredMinusDySquared.equals(java.math.BigInteger.ONE)) {
                return h_curr.longValue();
            }
            
            h_prev2 = h_prev1;
            h_prev1 = h_curr;
            k_prev2 = k_prev1;
            k_prev1 = k_curr;
        }
    }
}
