package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 4
 */
@Service
public class Haiku45OneByOneQ4 {

    public ResponseDto Question4() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Find the largest palindrome made from the product of two 3-digit numbers
        // Generated logic to solve the problem:
        int maxPalindrome = 0;
        for (int i = 999; i >= 100; i--) {
            for (int j = i; j >= 100; j--) {
                int product = i * j;
                if (product <= maxPalindrome) break;
                String productStr = String.valueOf(product);
                String reversed = new StringBuilder(productStr).reverse().toString();
                if (productStr.equals(reversed)) {
                    maxPalindrome = product;
                }
            }
        }
        Object result = maxPalindrome;
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
