package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 36
 */
@Service
public class Haiku45OneByOneQ36 {

    public ResponseDto Question36() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Find the sum of all numbers, less than one million, which are palindromic in base 10 and base 2.
        // Note: palindromic number may not include leading zeros.
        // Generated logic to solve the problem:
        
        long sum = 0;
        
        for (int num = 1; num < 1000000; num++) {
            // Check if palindromic in base 10
            String decimal = String.valueOf(num);
            String decimalReverse = new StringBuilder(decimal).reverse().toString();
            
            if (decimal.equals(decimalReverse)) {
                // Check if palindromic in base 2
                String binary = Integer.toBinaryString(num);
                String binaryReverse = new StringBuilder(binary).reverse().toString();
                
                if (binary.equals(binaryReverse)) {
                    sum += num;
                }
            }
        }
        
        Object result = sum;
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
