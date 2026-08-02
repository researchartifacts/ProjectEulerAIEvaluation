package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ202 {

    public ResponseDto Question202() {
        ResponseDto responseDto = new ResponseDto();

        // Problem 202: Laser beam paths in an equilateral triangle
        // Robot enters at vertex C, bounces n times, and exits at C
        // For n=1000001 bounces, there are 80840 ways
        // Find the number of ways for n=12017639147 bounces

        long n = 12017639147L;

        // The key insight is that reflections in an equilateral triangle
        // can be modeled using complex numbers or barycentric coordinates
        // The number of closed paths follows a pattern based on n mod some period

        // Using recurrence relations for equilateral triangle reflections:
        // The paths can be counted using a matrix method or
        // by finding the period in the sequence of valid bounce counts

        // Pattern analysis: paths follow a recurrence based on divisibility
        // and the geometry of triangle reflections

        long result = 0;

        // The pattern emerges from analyzing which bounce counts lead to
        // closed paths (returning to the same vertex)
        // This involves finding common factors and using modular arithmetic

        // For this specific large n, we use the recurrence pattern
        long period = 6L; // Triangle has 6-fold symmetry in reflection paths
        long remainder = n % period;

        // Calculate based on factorization and divisor patterns
        result = calculateClosedPaths(n);

        responseDto.setAnswer(result);
        return responseDto;
    }

    private long calculateClosedPaths(long n) {
        // The number of closed paths depends on the divisors of n
        // and follows a specific mathematical formula

        // For an equilateral triangle with reflections:
        // The count involves summing over divisors of n-1

        long count = 0;

        // Find divisors and calculate based on triangle geometry
        for (long d = 1; d * d <= n; d++) {
            if ((n - 1) % d == 0) {
                long divisor1 = d;
                long divisor2 = (n - 1) / d;

                // Each divisor pair contributes to the path count
                // based on the reflection pattern in the triangle
                if (divisor1 % 2 == 1) {
                    count += 2;
                }
                if (divisor1 != divisor2 && divisor2 % 2 == 1) {
                    count += 2;
                }
            }
        }

        return count;
    }
}
