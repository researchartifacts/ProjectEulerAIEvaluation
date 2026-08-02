package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 30
 */
@Service
public class Haiku45OneByOneQ30 {

    public ResponseDto Question30() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Find sum of all numbers that can be written as sum of fifth powers of their digits
        // Generated logic to solve the problem:
        long sum = 0;
        
        // Maximum possible number with 6 digits: 999999
        // Maximum sum of fifth powers: 6 * 9^5 = 6 * 59049 = 354294
        int maxNum = 354294;
        
        for (int num = 2; num <= maxNum; num++) {
            long sumOfFifthPowers = 0;
            int temp = num;
            
            // Calculate sum of fifth powers of digits
            while (temp > 0) {
                int digit = temp % 10;
                sumOfFifthPowers += digit * digit * digit * digit * digit;
                temp /= 10;
            }
            
            // If it equals the number, add to sum
            if (sumOfFifthPowers == num) {
                sum += num;
            }
        }
        
        Object result = sum;
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
