package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 87
 */
@Service
public class Haiku45OneByOneQ87 {

    public ResponseDto Question87() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Count numbers below 50 million = p^2 + p^3 + p^4 (p = prime)
        int limit = 50000000;
        
        // Generate primes using Sieve of Eratosthenes
        int maxPrime = (int) Math.sqrt(limit) + 1;
        boolean[] isPrime = new boolean[maxPrime + 1];
        java.util.Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        
        for (int i = 2; i * i <= maxPrime; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= maxPrime; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        
        java.util.Set<Long> validNumbers = new java.util.HashSet<>();
        
        // Generate all primes up to sqrt(limit)
        java.util.List<Long> primes = new java.util.ArrayList<>();
        for (int i = 2; i <= maxPrime; i++) {
            if (isPrime[i]) {
                primes.add((long) i);
            }
        }
        
        // Iterate through combinations of p^2, p^3, p^4
        for (long p2 : primes) {
            long pSq = p2 * p2;
            if (pSq >= limit) break;
            
            for (long p3 : primes) {
                long pCu = p3 * p3 * p3;
                if (pSq + pCu >= limit) break;
                
                for (long p4 : primes) {
                    long pFo = p4 * p4 * p4 * p4;
                    long sum = pSq + pCu + pFo;
                    if (sum >= limit) break;
                    
                    validNumbers.add(sum);
                }
            }
        }
        
        Object result = validNumbers.size();
        responseDto.setAnswer(result);
        return responseDto;
    }
}
