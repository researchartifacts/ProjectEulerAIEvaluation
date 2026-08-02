package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 77
 */
@Service
public class Haiku45OneByOneQ77 {

    public ResponseDto Question77() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Find first value that can be written as sum of primes in over 5,000 ways
        // Generated logic to solve the problem:
        
        // Generate primes up to a reasonable limit
        java.util.List<Integer> primes = generatePrimes(200);
        
        // Use dynamic programming to count ways
        long[] ways = new long[200];
        ways[0] = 1;
        
        // For each prime
        for (int prime : primes) {
            for (int n = prime; n < 200; n++) {
                ways[n] += ways[n - prime];
            }
        }
        
        // Find first number with more than 5000 ways
        for (int n = 2; n < 200; n++) {
            if (ways[n] > 5000) {
                Object result = n;
                responseDto.setAnswer(result);
                return responseDto;
            }
        }
        
        Object result = null;
        responseDto.setAnswer(result);
        return responseDto;
    }
    
    private java.util.List<Integer> generatePrimes(int limit) {
        boolean[] isPrime = new boolean[limit + 1];
        java.util.Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        
        for (int i = 2; i * i <= limit; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= limit; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        
        java.util.List<Integer> primes = new java.util.ArrayList<>();
        for (int i = 2; i <= limit; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
        
        return primes;
    }
}
