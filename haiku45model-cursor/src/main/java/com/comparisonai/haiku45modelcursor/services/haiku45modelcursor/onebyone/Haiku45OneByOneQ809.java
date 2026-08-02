package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 809: Sum of Powers
 * Find sum of p^q where p and q are primes and p^q < 10^15
 * Count each such sum only once
 */
@Service
public class Haiku45OneByOneQ809 {

    public ResponseDto Question809() {
        ResponseDto responseDto = new ResponseDto();

        // Generate all primes up to reasonable limit
        java.util.Set<Long> sums = new java.util.HashSet<>();
        long limit = 1000000000000000L; // 10^15
        
        java.util.List<Long> primes = generatePrimes(10000);
        
        // For each pair of primes p and q
        for (long p : primes) {
            long power = p;
            while (power < limit) {
                for (long q : primes) {
                    long result = power;
                    for (int i = 1; i < q; i++) {
                        if (result > limit / p) {
                            result = limit + 1;
                            break;
                        }
                        result *= p;
                    }
                    if (result < limit) {
                        sums.add(result);
                    }
                }
                if (power > limit / p) break;
                power *= p;
            }
        }
        
        long total = sums.stream().mapToLong(Long::longValue).sum();
        responseDto.setAnswer(total);
        return responseDto;
    }
    
    private java.util.List<Long> generatePrimes(int limit) {
        java.util.List<Long> primes = new java.util.ArrayList<>();
        boolean[] isPrime = new boolean[limit + 1];
        java.util.Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        
        for (int i = 2; i <= limit; i++) {
            if (isPrime[i]) {
                primes.add((long)i);
                for (int j = i * 2; j <= limit; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return primes;
    }
}
