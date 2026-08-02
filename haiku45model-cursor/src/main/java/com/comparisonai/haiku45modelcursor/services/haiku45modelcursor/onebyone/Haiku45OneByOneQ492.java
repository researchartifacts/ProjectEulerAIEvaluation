package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;

/**
 * Problem 492: Recursive Sequence and Prime Sum
 * Define sequence a_1 = 1, a_{n+1} = 6*a_n^2 + 10*a_n + 3
 * Calculate B(10^9, 10^7, 10^15) as sum of (a_n mod p) for primes p in range
 */
@Service
public class Haiku45OneByOneQ492 {

    private static final long MOD = 1_000_000_007;
    private static final long PRIME_START = 1_000_000_000L;
    private static final long PRIME_RANGE = 10_000_000L;
    private static final long N = 1_000_000_000_000_000L;

    public ResponseDto Question492() {
        ResponseDto responseDto = new ResponseDto();

        // Generate sequence values modulo various primes
        long result = calculateB();

        responseDto.setAnswer(result);
        return responseDto;
    }

    private long calculateB() {
        // Find all primes in range [10^9, 10^9 + 10^7]
        List<Long> primes = sievePrimes(PRIME_START, PRIME_START + PRIME_RANGE);
        
        long sum = 0;
        for (long prime : primes) {
            // Calculate a_N mod prime
            long aMod = calculateSequenceModulo(N, prime);
            sum = (sum + aMod) % MOD;
        }
        
        return sum;
    }

    private long calculateSequenceModulo(long n, long prime) {
        // a_1 = 1, a_{n+1} = 6*a_n^2 + 10*a_n + 3 (mod prime)
        long a = 1;
        for (long i = 1; i < n; i++) {
            long a_sq = (a * a) % prime;
            a = ((6 * a_sq % prime) + (10 * a % prime) + 3) % prime;
        }
        return a;
    }

    private List<Long> sievePrimes(long start, long end) {
        List<Long> primes = new ArrayList<>();
        
        // Simple primality testing for range
        for (long num = start; num <= end; num++) {
            if (isPrime(num)) {
                primes.add(num);
            }
        }
        
        return primes;
    }

    private boolean isPrime(long num) {
        if (num < 2) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        
        for (long i = 3; i * i <= num; i += 2) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
