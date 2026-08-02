package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 437 - Fibonacci Primitive Roots
 * 
 * A prime p has a Fibonacci primitive root if there exists an integer g such that:
 * g^n mod p generates all values 1 to p-1 (primitive root property) AND
 * g^n + g^(n+1) ≡ g^(n+2) (mod p) for all n (Fibonacci property)
 * 
 * Find sum of all primes less than 100,000,000 with at least one Fibonacci primitive root.
 */
@Service
public class Haiku45OneByOneQ437 {

    public ResponseDto Question437() {
        ResponseDto responseDto = new ResponseDto();

        long limit = 100_000_000L;
        long result = 0;

        // Generate all primes up to limit using Sieve of Eratosthenes
        java.util.List<Long> primes = sieveOfEratosthenes(limit);

        // For each prime, check if it has a Fibonacci primitive root
        for (long p : primes) {
            if (hasFibonacciPrimitiveRoot(p)) {
                result += p;
            }
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    private java.util.List<Long> sieveOfEratosthenes(long limit) {
        // Generate all primes up to limit
        if (limit < 2) return new java.util.ArrayList<>();
        
        boolean[] isPrime = new boolean[(int) (limit + 1)];
        java.util.Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        
        for (long i = 2; i * i <= limit; i++) {
            if (isPrime[(int) i]) {
                for (long j = i * i; j <= limit; j += i) {
                    isPrime[(int) j] = false;
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

    private boolean hasFibonacciPrimitiveRoot(long p) {
        // Check if prime p has a Fibonacci primitive root
        
        // First, find all primitive roots of p
        long phi = p - 1; // Euler's totient for prime p
        
        // Find all divisors of phi (needed to check primitive root condition)
        java.util.List<Long> divisors = getDivisors(phi);
        
        // Check each candidate g from 2 to p-1
        for (long g = 2; g < p; g++) {
            // Check if g is a primitive root mod p
            if (isPrimitiveRoot(g, p, divisors)) {
                // Check if g is also a Fibonacci primitive root
                if (isFibonacciRoot(g, p)) {
                    return true;
                }
            }
        }
        
        return false;
    }

    private boolean isPrimitiveRoot(long g, long p, java.util.List<Long> divisors) {
        // Check if g is a primitive root mod p
        // g is primitive root if g^((p-1)/d) mod p != 1 for all proper divisors d of p-1
        
        for (long d : divisors) {
            if (d == p - 1) continue; // Skip the full exponent
            
            long exp = (p - 1) / d;
            if (modPow(g, exp, p) == 1) {
                return false;
            }
        }
        
        return true;
    }

    private boolean isFibonacciRoot(long g, long p) {
        // Check if g^n + g^(n+1) ≡ g^(n+2) (mod p) for all n
        // This is equivalent to: g^n * (1 + g) ≡ g^(n+2) (mod p)
        // Which simplifies to: g^n * (1 + g) ≡ g^n * g^2 (mod p)
        // So: 1 + g ≡ g^2 (mod p)
        // Therefore: g^2 - g - 1 ≡ 0 (mod p)
        
        long lhs = (g * g - g - 1) % p;
        if (lhs < 0) lhs += p;
        
        return lhs == 0;
    }

    private java.util.List<Long> getDivisors(long n) {
        java.util.List<Long> divisors = new java.util.ArrayList<>();
        
        for (long i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                divisors.add(i);
                if (i != n / i) {
                    divisors.add(n / i);
                }
            }
        }
        
        java.util.Collections.sort(divisors);
        return divisors;
    }

    private long modPow(long base, long exp, long mod) {
        long result = 1;
        base = base % mod;
        
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % mod;
            }
            exp >>= 1;
            base = (base * base) % mod;
        }
        
        return result;
    }
}
