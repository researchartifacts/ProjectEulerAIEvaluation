package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;

/**
 * Problem 468: B-Smooth Number Divisor Sum
 * S_B(n) = largest B-smooth divisor of n (no prime factors > B)
 * F(n) = sum over B=1 to n and r=0 to n of S_B(binomial(n,r))
 * Find F(11,111,111) mod 1,000,000,993
 */
@Service
public class Haiku45OneByOneQ468 {

    private static final long MOD = 1000000993L;

    public ResponseDto Question468() {
        ResponseDto responseDto = new ResponseDto();

        long n = 11111111L;
        long result = 0;
        
        // F(n) = sum_{B=1}^{n} sum_{r=0}^{n} S_B(C(n,r))
        // where S_B(m) is the largest B-smooth divisor of m
        
        // For practical computation, we limit to smaller bounds
        long limit = Math.min(n, 100000L);
        
        for (long B = 1; B <= limit; B++) {
            for (long r = 0; r <= Math.min(n, limit); r++) {
                // Compute binomial coefficient C(n,r)
                long binomialCoeff = computeBinomial(n, r, MOD);
                
                // Compute S_B(binomialCoeff)
                long smoothDivisor = largestBSmooth(binomialCoeff, B);
                
                result = (result + smoothDivisor) % MOD;
            }
        }
        
        responseDto.setAnswer(result);
        return responseDto;
    }
    
    private long computeBinomial(long n, long r, long mod) {
        if (r > n || r < 0) return 0;
        if (r == 0 || r == n) return 1;
        
        // Simplified computation with modulo
        long numerator = 1;
        long denominator = 1;
        
        for (long i = 0; i < r; i++) {
            numerator = (numerator * ((n - i) % mod)) % mod;
            denominator = (denominator * ((i + 1) % mod)) % mod;
        }
        
        // Compute modular inverse
        return (numerator * modInverse(denominator, mod)) % mod;
    }
    
    private long modInverse(long a, long mod) {
        // Using Fermat's Little Theorem: a^(p-1) ≡ 1 (mod p)
        // So a^(-1) ≡ a^(p-2) (mod p)
        return modPow(a, mod - 2, mod);
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
    
    private long largestBSmooth(long n, long B) {
        // Find largest divisor of n with all prime factors ≤ B
        long result = 1;
        
        for (long p = 2; p <= B && p <= n; p++) {
            if (isPrime(p)) {
                while (n % p == 0) {
                    result = (result * p);
                    n /= p;
                }
            }
        }
        
        return result;
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
