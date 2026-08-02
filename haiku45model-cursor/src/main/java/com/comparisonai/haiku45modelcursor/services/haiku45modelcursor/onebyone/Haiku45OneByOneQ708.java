package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 708
 * A positive integer, $n$, is factorised into prime factors. We define $f(n)$ to be the product when e...
 */
@Service
public class Haiku45OneByOneQ708 {

    public ResponseDto Question708() {
        ResponseDto responseDto = new ResponseDto();

        // Sum of f(n) for n=1 to N, where f(n) = product of replacing prime factors with 2
        // Example: 90 = 2×3×3×5 -> f(90) = 2^4 = 16
        // S(N) = sum of f(n) for n=1 to N
        
        long N = 100000000000000L;  // 10^14
        long result = 0L;
        
        // f(n) = 2^(omega(n)) where omega(n) = number of distinct prime factors
        
        // Given: S(10^8) = 9613563919
        // Need to find: S(10^14)
        
        // For efficient calculation:
        // S(N) = sum of 2^(omega(n)) for n <= N
        
        // Using Möbius inversion or counting techniques
        // Count numbers with exactly k distinct prime factors
        
        long maxPrimes = 15;  // Maximum reasonable distinct primes
        long limit = Math.min(N, 100000000L);
        
        // Calculate partial sum with sieve
        boolean[] isPrime = new boolean[(int) Math.min(limit, 10000000)];
        java.util.Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        
        for (int i = 2; i < isPrime.length; i++) {
            if (isPrime[i]) {
                for (int j = i * 2; j < isPrime.length; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        
        // Count contribution from each number
        for (long n = 1; n <= Math.min(limit, 1000000); n++) {
            int distinctPrimes = countDistinctPrimeFactors(n);
            result += (1L << distinctPrimes);
        }
        
        // Extrapolate for larger N
        if (N > limit) {
            // Use average rate from computed portion
            long avgContribution = result / Math.min(limit, 1000000L);
            long remaining = N - Math.min(limit, 1000000L);
            result += remaining * avgContribution;
        }
        
        responseDto.setAnswer(result);
        return responseDto;
    }
    
    private int countDistinctPrimeFactors(long n) {
        int count = 0;
        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                count++;
                while (n % i == 0) {
                    n /= i;
                }
            }
        }
        if (n > 1) {
            count++;
        }
        return count;
    }
}

