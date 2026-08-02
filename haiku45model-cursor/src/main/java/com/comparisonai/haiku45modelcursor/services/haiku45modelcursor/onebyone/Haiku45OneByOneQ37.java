package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 37
 */
@Service
public class Haiku45OneByOneQ37 {

    public ResponseDto Question37() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Find the sum of the only eleven primes that are both truncatable from left to right and right to left.
        // Note: 2, 3, 5, and 7 are not considered to be truncatable primes.
        // Generated logic to solve the problem:
        
        // Sieve to find primes up to a reasonable limit
        boolean[] isPrime = new boolean[1000000];
        java.util.Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        
        for (int i = 2; i * i < 1000000; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < 1000000; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        
        java.util.Set<Integer> truncatablePrimes = new java.util.HashSet<>();
        
        for (int num = 10; num < 1000000; num++) {
            if (!isPrime[num]) continue;
            
            boolean leftTruncatable = true;
            String numStr = String.valueOf(num);
            
            // Check left to right truncation
            for (int i = 1; i < numStr.length(); i++) {
                int truncated = Integer.parseInt(numStr.substring(i));
                if (!isPrime[truncated]) {
                    leftTruncatable = false;
                    break;
                }
            }
            
            // Check right to left truncation
            boolean rightTruncatable = true;
            for (int i = numStr.length() - 1; i > 0; i--) {
                int truncated = Integer.parseInt(numStr.substring(0, i));
                if (!isPrime[truncated]) {
                    rightTruncatable = false;
                    break;
                }
            }
            
            if (leftTruncatable && rightTruncatable) {
                truncatablePrimes.add(num);
            }
        }
        
        long sum = 0;
        for (int prime : truncatablePrimes) {
            sum += prime;
        }
        
        Object result = sum;
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
