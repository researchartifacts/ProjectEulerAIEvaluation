package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 46
 */
@Service
public class Haiku45OneByOneQ46 {

    public ResponseDto Question46() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Find smallest odd composite that cannot be written as prime + 2*square
        // Generated logic to solve the problem:
        
        java.util.Set<Long> primes = new java.util.HashSet<>();
        
        // Generate primes up to 10000
        for (int n = 2; n < 10000; n++) {
            if (isPrime(n)) {
                primes.add((long) n);
            }
        }
        
        long result = 0;
        
        // Check odd composite numbers
        for (int n = 9; n < 10000; n += 2) {
            // Check if n is composite (not prime)
            if (!isPrime(n)) {
                boolean found = false;
                
                // Try to express as prime + 2*k^2
                for (long k = 1; 2 * k * k < n; k++) {
                    long remainder = n - 2 * k * k;
                    if (primes.contains(remainder)) {
                        found = true;
                        break;
                    }
                }
                
                if (!found) {
                    result = n;
                    break;
                }
            }
        }
        
        Object answer = result;
        
        responseDto.setAnswer(answer);
        return responseDto;
    }
    
    private boolean isPrime(long n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (long i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
