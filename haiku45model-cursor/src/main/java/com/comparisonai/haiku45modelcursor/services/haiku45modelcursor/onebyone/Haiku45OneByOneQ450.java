package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;

/**
 * Problem 450: Hypocycloid integer points
 * Calculate T(N) = sum of S(R, r) for all valid R and r up to N
 * where S(R, r) = sum of |x| + |y| for integer coordinate points on hypocycloid
 * Find T(10^6)
 */
@Service
public class Haiku45OneByOneQ450 {

    public ResponseDto Question450() {
        ResponseDto responseDto = new ResponseDto();

        long n = 1_000_000L;
        long result = 0;

        // Iterate through all valid (R, r) pairs
        for (long r = 1; r * 2 < n; r++) {
            for (long R = 3; R <= n; R++) {
                if (2 * r >= R) continue;

                // Calculate S(R, r)
                long sValue = calculateS(R, r);
                result += sValue;

                // Progress indicator
                if (R % 10_000 == 0) {
                    System.out.println("Progress: R = " + R + ", r = " + r + ", T = " + result);
                }
            }
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    /**
     * Calculate S(R, r) = sum of |x| + |y| for integer points on hypocycloid
     * with rational sin(t) and cos(t)
     */
    private long calculateS(long R, long r) {
        // Hypocycloid parametric equations:
        // x(t) = (R - r) cos(t) + r cos((R - r)/r * t)
        // y(t) = (R - r) sin(t) - r sin((R - r)/r * t)

        // Find all integer points where sin(t) and cos(t) are rational
        // These occur at special angles (fractions of 2π)

        Set<String> pointSet = new HashSet<>();
        long sum = 0;

        // Generate rational points using systematic approach
        // sin and cos are rational when t corresponds to certain arc tangent values
        
        long gcdRr = gcd(R, r);
        long period = 2 * R / gcdRr; // Period for integer points

        for (long t = 0; t < period; t++) {
            // Calculate position using rational arithmetic where possible
            double[] point = calculateHypocycloidPoint(R, r, t, period);

            if (point != null && isInteger(point[0]) && isInteger(point[1])) {
                long x = Math.round(point[0]);
                long y = Math.round(point[1]);

                String key = x + "," + y;
                if (!pointSet.contains(key)) {
                    pointSet.add(key);
                    sum += Math.abs(x) + Math.abs(y);
                }
            }
        }

        return sum;
    }

    /**
     * Calculate a point on the hypocycloid
     */
    private double[] calculateHypocycloidPoint(long R, long r, long t, long period) {
        double angle = 2.0 * Math.PI * t / period;
        double k = (double) (R - r) / r;

        double x = (R - r) * Math.cos(angle) + r * Math.cos(k * angle);
        double y = (R - r) * Math.sin(angle) - r * Math.sin(k * angle);

        return new double[] {x, y};
    }

    /**
     * Check if a value is approximately an integer
     */
    private boolean isInteger(double value) {
        return Math.abs(value - Math.round(value)) < 1e-9;
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
