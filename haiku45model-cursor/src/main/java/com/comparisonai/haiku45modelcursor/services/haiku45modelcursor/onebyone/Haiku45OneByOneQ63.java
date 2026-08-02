package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 63
 */
@Service
public class Haiku45OneByOneQ63 {

    public ResponseDto Question63() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: The 5-digit number, 16807=7^5, is also a fifth power. Similarly, the 9-digit ...
        // Generated logic to solve the problem:
        
        int count = 0;
        
        // For n-digit power: 10^(n-1) <= a^n < 10^n
        // So a <= 10 - epsilon for any n > 1
        // We iterate through possible bases and exponents
        for (int n = 1; n <= 25; n++) { // n-th power
            for (int a = 1; a <= 9; a++) { // base (single digit for n > 1 to have n digits)
                java.math.BigDecimal base = new java.math.BigDecimal(a);
                java.math.BigDecimal power = base.pow(n);
                
                int digits = power.toPlainString().length();
                if (digits == n) {
                    count++;
                } else if (digits > n) {
                    break; // No more valid bases for this n
                }
            }
        }
        
        Object result = count;
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
