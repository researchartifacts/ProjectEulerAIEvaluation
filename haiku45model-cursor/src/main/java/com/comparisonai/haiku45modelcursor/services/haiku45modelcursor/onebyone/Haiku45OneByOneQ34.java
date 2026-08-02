package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 34
 */
@Service
public class Haiku45OneByOneQ34 {

    public ResponseDto Question34() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: 145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.
        // Find the sum of all numbers which are equal to the sum of the factorial of their digits.
        // Note: 1! = 1 and 2! = 2 are not sums so they are not included.
        // Generated logic to solve the problem:
        
        // Pre-compute factorials
        int[] factorial = new int[10];
        factorial[0] = 1;
        for (int i = 1; i <= 9; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
        
        // Upper bound: 9 * 9! = 3,265,920
        long sum = 0;
        for (int num = 10; num <= 3000000; num++) {
            int factorialSum = 0;
            int temp = num;
            while (temp > 0) {
                factorialSum += factorial[temp % 10];
                temp /= 10;
            }
            
            if (factorialSum == num) {
                sum += num;
            }
        }
        
        Object result = sum;
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
