package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 74
 */
@Service
public class Haiku45OneByOneQ74 {

    public ResponseDto Question74() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Count how many chains with starting number below 1,000,000 contain exactly 60 non-repeating terms
        // Generated logic to solve the problem:
        
        long count = 0;
        
        for (long start = 1; start < 1000000; start++) {
            int chainLength = getChainLength(start);
            if (chainLength == 60) {
                count++;
            }
        }
        
        Object result = count;
        
        responseDto.setAnswer(result);
        return responseDto;
    }
    
    private int getChainLength(long n) {
        java.util.Set<Long> seen = new java.util.HashSet<>();
        int length = 0;
        
        while (!seen.contains(n)) {
            seen.add(n);
            n = sumOfFactorialOfDigits(n);
            length++;
        }
        
        return length;
    }
    
    private long sumOfFactorialOfDigits(long n) {
        long[] factorial = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
        long sum = 0;
        
        while (n > 0) {
            int digit = (int)(n % 10);
            sum += factorial[digit];
            n /= 10;
        }
        
        return sum;
    }
}
