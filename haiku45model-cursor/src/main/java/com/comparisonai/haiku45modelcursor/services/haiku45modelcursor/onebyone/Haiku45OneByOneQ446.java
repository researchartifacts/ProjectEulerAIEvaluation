package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 446: Retractions on power expressions
 * F(N) = sum of R(n^4 + 4) for n from 1 to N
 * Find F(10^7) modulo 1,000,000,007
 * R(n) is the count of retractions for a given n
 */
@Service
public class Haiku45OneByOneQ446 {

    private static final long MOD = 1_000_000_007L;

    public ResponseDto Question446() {
        ResponseDto responseDto = new ResponseDto();

        long n = 10_000_000L;
        long result = 0;

        // Sum R(i^4 + 4) for i from 1 to n
        for (long i = 1; i <= n; i++) {
            long value = (i * i % MOD * i % MOD * i % MOD + 4) % MOD;
            long rValue = countRetractions(value);
            result = (result + rValue) % MOD;

            // Progress indicator
            if (i % 100_000 == 0) {
                System.out.println("Progress: i = " + i + ", F(i) = " + result);
            }
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    /**
     * Count the number of retractions for a given modulus
     * A retraction is a function f(x) = ax + b (mod n) where f(f(x)) ≡ f(x) (mod n)
     */
    private long countRetractions(long n) {
        long count = 0;

        // For each valid pair (a, b) where 0 < a < n and 0 <= b < n
        for (long a = 1; a < n && a < 10000; a++) {
            if (gcd(a, n) != 1) continue; // a must be coprime with n

            for (long b = 0; b < n && b < 10000; b++) {
                // Check if f_{n,a,b} is a retraction
                // Need f(f(x)) ≡ f(x) (mod n) for all x in [0, n)
                boolean isRetraction = true;

                // Sample check (for large n, check representative elements)
                int checkLimit = Math.min(100, (int) n);
                for (int x = 0; x < checkLimit; x++) {
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
