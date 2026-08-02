package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 38
 */
@Service
public class Haiku45OneByOneQ38 {

    public ResponseDto Question38() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: What is the largest 1-9 pandigital 9-digit number that can be formed as the concatenated product
        // of an integer with (1, 2, ..., n) where n > 1?
        // Generated logic to solve the problem:
        
        long maxPandigital = 0;
        
        // Try different values of the base number
        for (int base = 1; base <= 10000; base++) {
            StringBuilder concat = new StringBuilder();
            
            for (int n = 1; n <= 10; n++) {
                concat.append(base * n);
                
                // If we have 9 digits, check if it's pandigital
                if (concat.length() == 9) {
                    String result = concat.toString();
                    boolean[] digits = new boolean[10];
                    boolean valid = true;
                    
                    for (char ch : result.toCharArray()) {
                        int digit = ch - '0';
                        if (digit == 0 || digits[digit]) {
                            valid = false;
                            break;
                        }
                        digits[digit] = true;
                    }
                    
                    if (valid) {
                        long pandigital = Long.parseLong(result);
                        maxPandigital = Math.max(maxPandigital, pandigital);
                    }
                    break;
                } else if (concat.length() > 9) {
                    break;
                }
            }
        }
        
        Object result = maxPandigital;
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
