package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;

/**
 * Problem 500: Smallest Number with Maximum Divisors
 * Find smallest number with 2^500500 divisors
 * Give answer modulo 500500507
 * Using highly composite number theory and prime factorization
 */
@Service
public class Haiku45OneByOneQ500 {

    private static final long MOD = 500_500_507L;
    private static final int TARGET_DIVISOR_POWER = 500_500;

    public ResponseDto Question500() {
        ResponseDto responseDto = new ResponseDto();

        long result = calculateSmallestNumberWithDivisors();

        responseDto.setAnswer(result);
        return responseDto;
    }

    private long calculateSmallestNumberWithDivisors() {
        // If a number has prime factorization n = p1^a1 * p2^a2 * ... * pk^ak
        // Then number of divisors = (a1+1) * (a2+1) * ... * (ak+1)
        
        // We need: (a1+1) * (a2+1) * ... * (ak+1) = 2^500500
        
        // To minimize n, we should:
        // 1. Use smallest primes
        // 2. Assign largest exponents to smallest primes
        
        // Factorize 2^500500 into factors (ai+1)
        List<Integer> factors = factorize2ToThePower(TARGET_DIVISOR_POWER);
        
        // Convert factors to exponents
        List<Integer> exponents = new ArrayList<>();
        for (int factor : factors) {
            exponents.add(factor - 1);
        }
        
        // Sort exponents in descending order for smallest primes
        Collections.sort(exponents, Collections.reverseOrder());
        
        // Get first k primes
        List<Long> primes = getFirstPrimes(exponents.size());
        
        // Calculate n = p1^a1 * p2^a2 * ... * pk^ak modulo MOD
        long result = 1;
        for (int i = 0; i < exponents.size(); i++) {
            long prime = primes.get(i);
            int exponent = exponents.get(i);
            
            result = (result * modPow(prime, exponent, MOD)) % MOD;
        }
        
        return result;
    }

    private List<Integer> factorize2ToThePower(int power) {
        // 2^power needs to be factorized into (a1+1)*(a2+1)*...
        // To minimize n, we want factors as close to each other as possible
        // and as large as possible (to reduce exponents)
        
        List<Integer> factors = new ArrayList<>();
        
        // Start by using factors close to sqrt(2^power)
        // For 2^500500, we use a greedy approach
        
        int remaining = power;
        while (remaining > 0) {
            // Find largest k such that 2^k <= 2^remaining
            int k = remaining;
            while (k > 0 && (1 << Math.min(k, 30)) > (1 << Math.min(remaining, 30))) {
                k--;
            }
            
            if (k == 0) k = 1;
            
            factors.add(1 << Math.min(k, 20));
            remaining -= k;
        }
        
        return factors;
    }

    private List<Long> getFirstPrimes(int count) {
        List<Long> primes = new ArrayList<>();
        long candidate = 2;
        
        while (primes.size() < count) {
            if (isPrime(candidate)) {
                primes.add(candidate);
            }
            candidate++;
        }
        
        return primes;
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

    private long modPow(long base, long exp, long mod) {
        long result = 1;
        base %= mod;
        
        while (exp > 0) {
            if (exp % 2 == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp /= 2;
        }
        
        return result;
    }
}
