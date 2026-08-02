package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 32
 */
@Service
public class Haiku45OneByOneQ32 {

    public ResponseDto Question32() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once.
        // The product 7254 is unusual as 39 × 186 = 7254, and concatenated 391867254 is 1-9 pandigital.
        // Find the sum of all products whose multiplicand/multiplier/product identity is 1-9 pandigital.
        // Generated logic to solve the problem:
        
        java.util.Set<Integer> uniqueProducts = new java.util.HashSet<>();
        
        // For a × b = c to be 1-9 pandigital when concatenated as "a" + "b" + "c"
        // Total digits must be 9
        for (int a = 1; a <= 9999; a++) {
            for (int b = a; b <= 9999; b++) {
                int c = a * b;
                String concat = "" + a + b + c;
                
                // Check if it's 1-9 pandigital
                if (concat.length() == 9) {
                    boolean[] digits = new boolean[10];
                    boolean valid = true;
                    for (char ch : concat.toCharArray()) {
                        int digit = ch - '0';
                        if (digit == 0 || digits[digit]) {
                            valid = false;
                            break;
                        }
                        digits[digit] = true;
                    }
                    if (valid) {
                        uniqueProducts.add(c);
                    }
                } else if (concat.length() > 9) {
                    break; // b is too large, no point continuing
                }
            }
        }
        
        long sum = 0;
        for (int product : uniqueProducts) {
            sum += product;
        }
        
        Object result = sum;
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
