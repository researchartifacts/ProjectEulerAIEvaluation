package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 23
 */
@Service
public class Haiku45OneByOneQ23 {

    public ResponseDto Question23() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Find sum of positive integers that cannot be written as sum of two abundant numbers
        // Abundant number: sum of proper divisors > the number itself
        // Generated logic to solve the problem:
        long sum = 0;
        int limit = 28124;
        
        // Function to calculate sum of proper divisors
        int[] divisorSum = new int[limit];
        for (int i = 1; i < limit; i++) {
            divisorSum[i] = 0;
            for (int j = 1; j * j <= i; j++) {
                if (i % j == 0) {
                    if (j < i) divisorSum[i] += j;
                    if (j != i / j && i / j < i) divisorSum[i] += i / j;
                }
            }
        }
        
        // Find abundant numbers
        boolean[] isAbundant = new boolean[limit];
        for (int i = 1; i < limit; i++) {
            isAbundant[i] = divisorSum[i] > i;
        }
        
        // Find which numbers can be expressed as sum of two abundant numbers
        boolean[] canBeExpressed = new boolean[limit];
        for (int a = 1; a < limit; a++) {
            if (isAbundant[a]) {
                for (int b = a; a + b < limit; b++) {
                    if (isAbundant[b]) {
                        canBeExpressed[a + b] = true;
                    }
                }
            }
        }
        
        // Sum all numbers that cannot be expressed
        for (int i = 1; i < limit; i++) {
            if (!canBeExpressed[i]) {
                sum += i;
            }
        }
        
        Object result = sum;
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
