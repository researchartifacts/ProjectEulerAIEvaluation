package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;

/**
 * Problem 474: Last digits of divisors
 * Find F(10^6!, 65432) modulo (10^16 + 61)
 */
@Service
public class Haiku45OneByOneQ474 {

    private static final long MOD = 10_000_000_000_000_061L;

    public ResponseDto Question474() {
        ResponseDto responseDto = new ResponseDto();

        // F(n, d) = count of divisors of n whose last digits equal d
        // Need to find F(10^6!, 65432)
        
        long result = calculateF(1000000, 65432);
        responseDto.setAnswer(result % MOD);
        return responseDto;
    }

    private long calculateF(long n, long lastDigits) {
        // F(n!, lastDigits) = count of divisors of n! ending with lastDigits
        
        // Prime factorization approach: 
        // For a divisor to end with specific digits, we need to analyze
        // the structure of divisors formed from prime factors of n!
        
        long count = 0;
        int targetLength = String.valueOf(lastDigits).length();
        int targetMod = (int)(lastDigits % 1_000_000_000);
        
        // Strategy: Use dynamic programming with prime factorization
        // Build divisors and check their last digits
        Map<Long, Integer> primeFactors = getPrimeFactorization(n);
        
        // Generate divisors using prime factors
        count = countDivisorsWithLastDigits(primeFactors, targetMod, targetLength);
        
        return count % MOD;
    }

    private Map<Long, Integer> getPrimeFactorization(long n) {
        Map<Long, Integer> factors = new HashMap<>();
        
        // Count how many times each prime p divides n!
        for (long p = 2; p <= n; p = nextPrime(p)) {
            long exp = 0;
            long pk = p;
            while (pk <= n) {
                exp += n / pk;
                pk *= p;
                if (pk < 0) break; // Overflow prevention
            }
            if (exp > 0) {
                factors.put(p, (int) Math.min(exp, Integer.MAX_VALUE));
            }
        }
        
        return factors;
    }

    private long nextPrime(long p) {
        if (p == 2) return 3;
        long candidate = p + 2;
        while (!isPrime(candidate)) {
            candidate += 2;
        }
        return candidate;
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

    private long countDivisorsWithLastDigits(Map<Long, Integer> primeFactors, 
                                              int targetMod, int targetLength) {
        // Use DP to count divisors whose last digits match target
        Map<Integer, Long> dp = new HashMap<>();
        dp.put(1, 1L);
        
        for (Map.Entry<Long, Integer> entry : primeFactors.entrySet()) {
            long prime = entry.getKey();
            int exponent = entry.getValue();
            Map<Integer, Long> newDp = new HashMap<>();
            
            for (Map.Entry<Integer, Long> dpEntry : dp.entrySet()) {
                int mod = dpEntry.getKey();
                long count = dpEntry.getValue();
                
                // Multiply by different powers of this prime
                long powMod = 1;
                for (int i = 0; i <= exponent && i <= 50; i++) {
                    int newMod = (int)((mod * powMod) % (1_000_000_000L));
                    newDp.put(newMod, newDp.getOrDefault(newMod, 0L) + count);
                    powMod = (powMod * prime) % (1_000_000_000L);
                }
            }
            dp = newDp;
        }
        
        // Count divisors with matching last digits
        long result = dp.getOrDefault(targetMod, 0L);
        return result % MOD;
    }
}
