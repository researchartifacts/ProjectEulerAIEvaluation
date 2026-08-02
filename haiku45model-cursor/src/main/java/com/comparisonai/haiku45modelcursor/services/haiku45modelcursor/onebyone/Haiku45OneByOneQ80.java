package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 80
 */
@Service
public class Haiku45OneByOneQ80 {

    public ResponseDto Question80() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Sum of digital sums of first 100 decimal digits for irrational square roots (1-100)
        // Generated logic to solve the problem:
        
        long totalSum = 0;
        
        for (int n = 1; n <= 100; n++) {
            // Check if n is a perfect square
            int sqrt = (int) Math.sqrt(n);
            if (sqrt * sqrt != n) {
                // n is not a perfect square, so its square root is irrational
                // Calculate first 100 decimal digits and sum them
                int digitSum = getDigitalSum(n, 100);
                totalSum += digitSum;
            }
        }
        
        Object result = totalSum;
        
        responseDto.setAnswer(result);
        return responseDto;
    }
    
    private int getDigitalSum(int n, int numDecimalPlaces) {
        // Use BigDecimal for high precision
        java.math.BigDecimal num = new java.math.BigDecimal(n);
        java.math.MathContext mc = new java.math.MathContext(numDecimalPlaces + 10);
        java.math.BigDecimal sqrt = num.sqrt(mc);
        
        // Convert to string and extract digits (skip decimal point)
        String sqrtStr = sqrt.toPlainString().replace(".", "");
        
        int sum = 0;
        int count = 0;
        
        for (char c : sqrtStr.toCharArray()) {
            if (Character.isDigit(c)) {
                sum += Character.getNumericValue(c);
                count++;
                if (count >= numDecimalPlaces + 1) { // +1 for the integer part
                    break;
                }
            }
        }
        
        return sum;
    }
}
