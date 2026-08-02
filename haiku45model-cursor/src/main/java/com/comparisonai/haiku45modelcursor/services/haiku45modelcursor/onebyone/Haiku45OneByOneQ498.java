package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 498: Polynomial Remainder Coefficient
 * F_n(x) = x^n, G_m(x) = (x-1)^m
 * R_{n,m}(x) = remainder of F_n(x) / G_m(x)
 * C(n,m,d) = absolute value of coefficient of x^d in R_{n,m}(x)
 * Find C(10^13, 10^12, 10^4) mod 999999937
 */
@Service
public class Haiku45OneByOneQ498 {

    private static final long MOD = 999_999_937L;

    public ResponseDto Question498() {
        ResponseDto responseDto = new ResponseDto();

        long n = 10_000_000_000_000L;
        long m = 1_000_000_000_000L;
        int d = 10_000;
        
        long result = calculateC(n, m, d);

        responseDto.setAnswer(result);
        return responseDto;
    }

    private long calculateC(long n, long m, int d) {
        // Polynomial division of x^n by (x-1)^m gives remainder
        // The remainder R_{n,m}(x) has degree < m
        
        // Using binomial theorem: x^n = (x-1+1)^n
        // Coefficients in Taylor expansion around x=1
        
        if (d >= m) return 0;
        
        // Coefficient of x^d in (x-1)^m expanded
        // R_{n,m}(x) = sum of C(n,k) * (x-1)^k for k < m
        
        // Calculate using binomial coefficients and modular arithmetic
        long coeff = 0;
        
        for (int k = d; k < m && k <= d + 100; k++) {
            // Binomial coefficient C(n, k)
            long binomCoeff = binomialModulo(n, k);
            
            // Binomial coefficient C(k, d)
            long binomCoeff2 = binomialModulo(k, d);
            
            // Contribution: C(n,k) * C(k,d) * (-1)^(k-d)
            long contrib = (binomCoeff * binomCoeff2) % MOD;
            
            if ((k - d) % 2 == 0) {
                coeff = (coeff + contrib) % MOD;
            } else {
                coeff = (coeff - contrib + MOD) % MOD;
            }
        }
        
        return coeff;
    }

    private long binomialModulo(long n, long k) {
        if (k > n || k < 0) return 0;
        if (k == 0 || k == n) return 1;
        if (k > n - k) k = n - k;
        
        long result = 1;
        for (long i = 0; i < k; i++) {
            result = result * ((n - i) % MOD) % MOD;
            result = result * modInverse(i + 1, MOD) % MOD;
        }
        
        return result;
    }

    private long modInverse(long a, long m) {
        // Using Fermat's little theorem: a^(p-1) ≡ 1 (mod p)
        // So a^(-1) ≡ a^(p-2) (mod p)
        return modPow(a, m - 2, m);
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
