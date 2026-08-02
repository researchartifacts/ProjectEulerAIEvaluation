package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 445: Retractions and retraction count
 * f_{n,a,b}(x) ≡ ax + b (mod n) is a retraction if f(f(x)) ≡ f(x) (mod n)
 * Calculate sum of R(C(10^7, k)) for k from 1 to 9,999,999
 * Result modulo 1,000,000,007
 */
@Service
public class Haiku45OneByOneQ445 {

    private static final long MOD = 1_000_000_007L;

    public ResponseDto Question445() {
        ResponseDto responseDto = new ResponseDto();

        long n = 10_000_000L;
        long result = 0;

        // Sum R(C(n, k)) for k from 1 to n-1
        for (long k = 1; k < n; k++) {
            long binomCoeff = binomialCoefficient(n, k);
            long rValue = countRetractions(binomCoeff);
            result = (result + rValue) % MOD;

            // Progress indicator
            if (k % 100_000 == 0) {
                System.out.println("Progress: k = " + k + ", result = " + result);
            }
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    /**
     * Calculate the number of retractions for a given n
     * f(f(x)) ≡ f(x) (mod n) for all 0 <= x < n
     * This means f(x) must be an idempotent element
     */
    private long countRetractions(long n) {
        long count = 0;

        // For each valid pair (a, b) where 0 < a < n and 0 <= b < n
        for (long a = 1; a < n; a++) {
            if (gcd(a, n) != 1) continue; // a must be coprime with n

            for (long b = 0; b < n; b++) {
                // Check if f_{n,a,b} is a retraction
                boolean isRetraction = true;

                for (long x = 0; x < n; x++) {
                    long fx = (a * x + b) % n;
                    long ffx = (a * fx + b) % n;

                    if (ffx != fx) {
                        isRetraction = false;
                        break;
                    }
                }

                if (isRetraction) {
                    count++;
                }
            }
        }

        return count % MOD;
    }

    /**
     * Compute binomial coefficient C(n, k) modulo MOD
     */
    private long binomialCoefficient(long n, long k) {
        if (k > n) return 0;
        if (k == 0 || k == n) return 1;

        // Use multiplicative formula: C(n,k) = n!/(k!(n-k)!)
        long result = 1;
        k = Math.min(k, n - k);

        for (long i = 0; i < k; i++) {
            result = result * ((n - i) % MOD) % MOD;
            result = result * modInverse(i + 1, MOD) % MOD;
        }

        return result;
    }

    /**
     * Calculate modular multiplicative inverse using extended Euclidean algorithm
     */
    private long modInverse(long a, long mod) {
        long[] result = extendedGcd(a, mod);
        if (result[0] != 1) return -1;
        return (result[1] % mod + mod) % mod;
    }

    /**
     * Extended Euclidean algorithm
     */
    private long[] extendedGcd(long a, long b) {
        if (b == 0) return new long[] {a, 1, 0};

        long[] sub = extendedGcd(b, a % b);
        long gcd = sub[0];
        long x = sub[2];
        long y = sub[1] - (a / b) * sub[2];

        return new long[] {gcd, x, y};
    }

    /**
     * Calculate greatest common divisor
     */
    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
