package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 50
 */
@Service
public class Haiku45OneByOneQ50 {

    public ResponseDto Question50() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Find prime < 1M that can be written as sum of most consecutive primes
        // Generated logic to solve the problem:
        
        // Generate all primes below 1 million
        java.util.List<Long> primes = sievePrimes(1000000);
        java.util.Set<Long> primeSet = new java.util.HashSet<>(primes);
        
        long resultPrime = 0;
        int maxLength = 0;
        
        // Try all starting positions
        for (int start = 0; start < primes.size(); start++) {
            long sum = 0;
            // Try all ending positions from start
            for (int end = start; end < primes.size(); end++) {
                sum += primes.get(end);
                
                if (sum >= 1000000) break;
                
                // Check if sum is prime and track if it has more consecutive terms
                int length = end - start + 1;
                if (primeSet.contains(sum) && length > maxLength) {
                    maxLength = length;
                    resultPrime = sum;
                }
            }
        }
        
        Object answer = resultPrime;
        
        responseDto.setAnswer(answer);
        return responseDto;
    }
    
    private java.util.List<Long> sievePrimes(int limit) {
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
        
        java.util.List<Long> primes = new java.util.ArrayList<>();
        for (int i = 2; i <= limit; i++) {
            if (isPrime[i]) {
                primes.add((long) i);
            }
        }
        return primes;
    }
}
