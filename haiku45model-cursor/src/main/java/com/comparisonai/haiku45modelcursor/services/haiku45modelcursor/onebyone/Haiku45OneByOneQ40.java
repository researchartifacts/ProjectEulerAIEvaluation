package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 40
 */
@Service
public class Haiku45OneByOneQ40 {

    public ResponseDto Question40() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: An irrational decimal fraction is created by concatenating the positive integers: 0.123456789101112...
        // Find: d₁ × d₁₀ × d₁₀₀ × d₁,₀₀₀ × d₁₀,₀₀₀ × d₁₀₀,₀₀₀ × d₁,₀₀₀,₀₀₀
        // where dₙ represents the nth digit of the fractional part.
        // Generated logic to solve the problem:
        
        // Build the concatenated decimal string up to the 1,000,000th digit
        StringBuilder decimal = new StringBuilder();
        int num = 1;
        
        while (decimal.length() < 1000000) {
            decimal.append(num);
            num++;
        }
        
        // Get specific digits (1-indexed)
        int d1 = decimal.charAt(0) - '0';
        int d10 = decimal.charAt(9) - '0';
        int d100 = decimal.charAt(99) - '0';
        int d1000 = decimal.charAt(999) - '0';
        int d10000 = decimal.charAt(9999) - '0';
        int d100000 = decimal.charAt(99999) - '0';
        int d1000000 = decimal.charAt(999999) - '0';
        
        long result_val = (long) d1 * d10 * d100 * d1000 * d10000 * d100000 * d1000000;
        
        Object result = result_val;
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
