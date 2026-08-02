package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 457
 * Let f(n) = n^2 - 3n - 1
 * R(p) = smallest positive integer n such that f(n) mod p^2 = 0
 * Find SR(10^7) = sum of R(p) for all primes <= 10^7
 */
@Service
public class Haiku45OneByOneQ457 {

    public ResponseDto Question457() {
        ResponseDto responseDto = new ResponseDto();
        
        long limit = 10_000_000;
        
        // Find all primes up to limit using Sieve of Eratosthenes
        boolean[] isPrime = sieveOfEratosthenes((int)limit);
        
        long sumR = 0;
        
        // For each prime p <= limit
        for (int p = 2; p <= limit; p++) {
            if (isPrime[p]) {
                long rp = findR(p);
                sumR += rp;
            }
        }
        
        responseDto.setAnswer(sumR);
        return responseDto;
    }
    
    private long findR(long p) {
        // Find smallest positive n such that f(n) = n^2 - 3n - 1 ≡ 0 (mod p^2)
        long pSquared = p * p;
        
        // First find solutions modulo p
        long[] solutionsModP = findSolutionsModP(p);
        
        if (solutionsModP == null || solutionsModP.length == 0) {
            return 0;
        }
        
        // Lift solutions from mod p to mod p^2 using Hensel's lemma
        long minR = Long.MAX_VALUE;
        
        for (long nModP : solutionsModP) {
            if (nModP == 0) continue;
            
            // Hensel lifting
            long n = nModP;
            
            // f(n) = n^2 - 3n - 1
            long fn = ((n * n) - (3 * n) - 1) % pSquared;
            
            if (fn < 0) fn += pSquared;
            
            // Try to lift to mod p^2
            if (fn == 0) {
                minR = Math.min(minR, n);
            } else {
                // Use Hensel lifting to find the lift
                long f_prime = (2 * n - 3) % p;
                if (f_prime == 0) {
                    // Try linear search around n
                    for (long i = 0; i < p; i++) {
                        long candidate = nModP + i * p;
                        long fCandidate = candidate * candidate - 3 * candidate - 1;
                        if (fCandidate % pSquared == 0) {
                            minR = Math.min(minR, candidate);
                            break;
                        }
                    }
                } else {
                    long t = ((-fn / p) * modularInverse(f_prime, p)) % p;
                    if (t < 0) t += p;
                    long lifted = nModP + t * p;
                    minR = Math.min(minR, lifted);
                }
            }
        }
        
        return minR == Long.MAX_VALUE ? 0 : minR;
    }
    
    private long[] findSolutionsModP(long p) {
        // Find n such that n^2 - 3n - 1 ≡ 0 (mod p)
        // Using quadratic formula: n = (3 ± sqrt(9 + 4)) / 2 = (3 ± sqrt(13)) / 2
        
        long discriminant = 13 % p;
        
        // Find square root of discriminant mod p
        long sqrt = tonelliShanks(discriminant, p);
        
        if (sqrt == -1) {
            return null; // No solution
        }
        
        long inv2 = modularInverse(2, p);
        
        long n1 = ((3 + sqrt) * inv2) % p;
        long n2 = ((3 - sqrt + p) * inv2) % p;
        
        if (n1 == n2) {
            return new long[]{n1};
        } else {
            return new long[]{n1, n2};
        }
    }
    
    private long tonelliShanks(long n, long p) {
        // Find square root of n mod p
        if (n == 0) return 0;
        
        long pow = modularExponentiation(n, (p - 1) / 2, p);
        if (pow == p - 1) return -1; // No square root
        if (pow == 1 && n == 1) return 1;
        
        // Simplified: just try all values for small primes
        for (long i = 0; i < p; i++) {
            if ((i * i) % p == n % p) {
                return i;
            }
        }
        return -1;
    }
    
    private long modularInverse(long a, long p) {
        return modularExponentiation(a, p - 2, p);
    }
    
    private long modularExponentiation(long base, long exp, long modulo) {
        long result = 1;
        base %= modulo;
        if (base < 0) base += modulo;
        
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % modulo;
            }
            base = (base * base) % modulo;
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
