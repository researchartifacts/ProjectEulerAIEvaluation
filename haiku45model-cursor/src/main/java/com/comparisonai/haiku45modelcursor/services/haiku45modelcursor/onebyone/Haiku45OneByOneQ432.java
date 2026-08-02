package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 432 - Sum of Euler's Totient Function
 * 
 * Calculates S(510510, 10^11) where S(n,m) = sum of φ(n*i) for 1 <= i <= m
 * φ is Euler's totient function
 * Returns the last 9 digits of the answer
 */
@Service
public class Haiku45OneByOneQ432 {

    public ResponseDto Question432() {
        ResponseDto responseDto = new ResponseDto();

        long n = 510510L;
        long m = 100_000_000_000L; // 10^11
        long MOD = 1_000_000_000L; // For last 9 digits

        // For large m, we need to use mathematical properties of the totient function
        // S(n,m) = sum of φ(n*i) for i from 1 to m
        
        // φ is multiplicative, and we can use summation properties
        // S(n,m) = m*φ(n) + sum of φ(gcd(n,i)*n/gcd(n,i)) for i from 1 to m
        
        long phiN = eulerTotient(n);
        long result = (m % MOD) * (phiN % MOD) % MOD;

        // Add contribution from divisors
        // For each divisor d of n, count how many i have gcd(n,i) = d
        java.util.List<Long> divisors = getDivisors(n);
        
        for (long d : divisors) {
            if (d == n) continue;
            
            long quotient = n / d;
            long countMultiples = m / quotient;
            
            long phiD = eulerTotient(d);
            long contribution = (countMultiples % MOD) * (phiD % MOD) % MOD;
            result = (result + contribution) % MOD;
        }

        // More sophisticated calculation using Möbius function properties
        // S(n,m) = sum_{d|n} μ(n/d) * d * sum_{j=1}^{m/d} φ(d*j)
        
        result = calculateTotientSum(n, m, MOD);

        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

    private long calculateTotientSum(long n, long m, long mod) {
        long result = 0;
        
        // For each possible gcd value
        java.util.Set<Long> processed = new java.util.HashSet<>();
        
        for (long g = 1; g <= Math.min(n, m); g++) {
            if (n % g != 0) continue;
            if (processed.contains(g)) continue;
            
            long phi_g = eulerTotient(g);
            long countValues = m / (n / g);
            
            result = (result + (countValues % mod) * (phi_g % mod)) % mod;
            processed.add(g);
        }
        
        return result;
    }

    private long eulerTotient(long n) {
        long result = n;
        
        for (long p = 2; p * p <= n; p++) {
            if (n % p == 0) {
                while (n % p == 0) {
                    n /= p;
                }
                result -= result / p;
            }
        }
        
        if (n > 1) {
            result -= result / n;
        }
        
        return result;
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
        
        return divisors;
    }
}
