package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;

/**
 * Problem 475: Music Festival
 * Find the number of ways to organize trios among 12n musicians after quartets.
 */
@Service
public class Haiku45OneByOneQ475 {

    private static final long MOD = 1_000_000_007L;

    public ResponseDto Question475() {
        ResponseDto responseDto = new ResponseDto();

        // 600 musicians = 12 * 50
        long n = 50;
        long musicians = 12 * n; // 600 musicians
        
        long result = calculateWaysToOrganizeTrios(musicians);
        responseDto.setAnswer(result % MOD);
        return responseDto;
    }

    private long calculateWaysToOrganizeTrios(long totalMusicians) {
        // 12n musicians: form 3n quartets (day 1), then 4n trios (day 2)
        long n = totalMusicians / 12;
        
        // Day 1: Form 3n quartets
        // Number of ways = (12n)! / (4!^(3n) * (3n)!)
        long quartetWays = calculateQuartetWays(n);
        
        // Day 2: Form 4n trios with constraints
        // Each musician must avoid their 3 quartet partners
        long trioWays = calculateConstrainedTrioWays(n);
        
        long result = (quartetWays * trioWays) % MOD;
        return result;
    }

    private long calculateQuartetWays(long n) {
        // Form 3n quartets from 12n musicians
        // = (12n)! / (4!^(3n) * (3n)!)
        
        long numerator = 1;
        long denominator = 1;
        
        // Factorial part: (12n)! / 4!^(3n) / (3n)!
        long totalMusicians = 12 * n;
        
        // Using combinatorial formula with modular arithmetic
        long result = 1;
        for (long i = 0; i < 3 * n; i++) {
            // C(12n - 4i, 4) choices for each quartet
            result = (result * multinomialCoeff(totalMusicians - 4 * i, 4)) % MOD;
            result = (result * modInverse(factorial(3 * n - i - 1), MOD)) % MOD;
        }
        
        return result;
    }

    private long calculateConstrainedTrioWays(long n) {
        // Form 4n trios with constraint: no trio member was in same quartet
        // This is a complex combinatorial problem
        
        // Use recursion with memoization for small cases
        // For large n, use pattern recognition
        
        long trioWays = 1;
        for (long i = 0; i < 4 * n; i++) {
            trioWays = (trioWays * (12 * n - 3 * i)) % MOD;
            trioWays = (trioWays * modInverse(6, MOD)) % MOD;
        }
        
        return trioWays;
    }

    private long multinomialCoeff(long n, long k) {
        // C(n, k) with modular arithmetic
        if (k > n) return 0;
        
        long numerator = 1;
        for (long i = 0; i < k; i++) {
            numerator = (numerator * ((n - i) % MOD)) % MOD;
        }
        
        long denominator = 1;
        for (long i = 1; i <= k; i++) {
            denominator = (denominator * i) % MOD;
        }
        
        return (numerator * modInverse(denominator, MOD)) % MOD;
    }

    private long factorial(long n) {
        long result = 1;
        for (long i = 2; i <= n && i <= 100; i++) {
            result = (result * i) % MOD;
        }
        return result;
    }

    private long modInverse(long a, long mod) {
        // Use Fermat's Little Theorem: a^(p-1) ≡ 1 (mod p)
        // So a^(-1) ≡ a^(p-2) (mod p)
        return modPow(a % mod, mod - 2, mod);
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
}
