package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 429: Unitary divisor squares of factorials
 * Find sum of squares of unitary divisors of 100,000,000! modulo 10^9+9
 */
@Service
public class Haiku45OneByOneQ429 {

    private static final long MOD = 1000000009L;
    
    public ResponseDto Question429() {
        ResponseDto responseDto = new ResponseDto();

        long n = 100000000L;
        
        // S(n) = sum of squares of unitary divisors of n
        // For n = m!, need to find prime factorization first
        
        // Key insight: For n = p1^a1 * p2^a2 * ... * pk^ak
        // Unitary divisors are products of subsets of prime powers
        // S(n) = (1 + p1^(2*a1)) * (1 + p2^(2*a2)) * ... * (1 + pk^(2*ak))
        
        // For m!, the exponent of prime p is sum floor(m/p^i)
        
        long result = 1;
        
        // Generate primes up to n
        int limit = (int)Math.min(n, 10000000);
        boolean[] isPrime = sieveOfEratosthenes(limit);
        
        // For each prime p <= m
        for (int p = 2; p <= limit; p++) {
            if (isPrime[p]) {
                // Calculate exponent of p in m!
                long exponent = 0;
                long pk = p;
                
                while (pk <= n) {
                    exponent += n / pk;
                    if (pk > n / p) break; // Avoid overflow
                    pk *= p;
                }
                
                // Contribution to S(m!) is (1 + p^(2*exponent))
                if (exponent > 0) {
                    long contribution = 1;
                    long power = modPow(p, 2 * exponent, MOD);
                    contribution = (1 + power) % MOD;
                    result = (result * contribution) % MOD;
                }
            }
        }
        
        responseDto.setAnswer(result);
        return responseDto;
    }
    
    private long modPow(long base, long exp, long mod) {
        long result = 1;
        base %= mod;
        
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }
        
        return result;
    }
    
    private boolean[] sieveOfEratosthenes(int limit) {
        boolean[] isPrime = new boolean[limit + 1];
        
        for (int i = 2; i <= limit; i++) {
            isPrime[i] = true;
        }
        
        for (int i = 2; i * i <= limit; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= limit; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        
        return isPrime;
    }
}
