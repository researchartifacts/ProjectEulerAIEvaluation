package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 443: Sequence g(n)
 * g(4) = 13, g(n) = g(n-1) + gcd(n, g(n-1)) for n > 4
 * Find g(10^15)
 */
@Service
public class Haiku45OneByOneQ443 {

    public ResponseDto Question443() {
        ResponseDto responseDto = new ResponseDto();

        long n = 1_000_000_000_000_000L; // 10^15
        long gValue = 13; // g(4) = 13

        // Iterate from 5 to n, computing g(n) = g(n-1) + gcd(n, g(n-1))
        for (long i = 5; i <= n; i++) {
            long gcdValue = gcd(i, gValue);
            gValue = gValue + gcdValue;

            // Progress indicator - every 10 million iterations
            if (i % 10_000_000 == 0) {
                System.out.println("Progress: i = " + i + ", g(i) = " + gValue);
            }
        }

        responseDto.setAnswer(gValue);
        return responseDto;
    }

    /**
     * Calculate the greatest common divisor using Euclidean algorithm
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
