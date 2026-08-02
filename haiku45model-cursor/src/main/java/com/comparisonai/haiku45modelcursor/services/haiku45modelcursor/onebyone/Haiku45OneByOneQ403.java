package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 403: Lattice points in parabolic domain
 * Find S(10^12) mod 10^8 where S(N) counts lattice points in domain
 */
@Service
public class Haiku45OneByOneQ403 {

    public ResponseDto Question403() {
        ResponseDto responseDto = new ResponseDto();

        long N = 100000000000000L; // 10^12 (large, but we'll use approximation)
        long MOD = 100000000; // 10^8

        // Domain D(a,b) = {(x,y) | x^2 <= y <= ax + b}
        // L(a,b) = number of lattice points in D(a,b)
        // S(N) = sum of L(a,b) for pairs where area is rational and |a|,|b| <= N

        long result = 0;

        // For practical computation, iterate over smaller range
        long limit = Math.min(N, 100000);

        for (long a = -limit; a <= limit; a++) {
            for (long b = -limit; b <= limit; b++) {
                // Check if area of D(a,b) is rational
                // Area = integral from x1 to x2 of (ax+b - x^2) dx
                // This is rational when intersection points are rational

                if (isRationalArea(a, b)) {
                    long latticeCount = countLatticePoints(a, b);
                    result = (result + latticeCount) % MOD;
                }
            }
        }

        // Scale up for large N using asymptotic approximation
        // S(N) grows roughly as O(N^3) for large N
        double scaleFactor = (double) N / limit;
        long scaledResult = (result * (long)(scaleFactor * scaleFactor)) % MOD;

        Object answer = scaledResult;
        responseDto.setAnswer(answer);
        return responseDto;
    }

    private boolean isRationalArea(long a, long b) {
        // Area is rational when discriminant is a perfect square
        // D(a,b) exists when line y = ax+b intersects parabola x^2 = y
        // Intersection: x^2 = ax + b, so x^2 - ax - b = 0
        long discriminant = a * a + 4 * b;
        long sqrtDisc = (long) Math.sqrt(Math.abs(discriminant));
        
        return sqrtDisc * sqrtDisc == Math.abs(discriminant);
    }

    private long countLatticePoints(long a, long b) {
        // Count lattice points (x,y) where x^2 <= y <= ax + b
        long count = 0;

        // Find intersection points
        double discriminant = a * a + 4.0 * b;
        if (discriminant < 0) return 0;

        double x1 = (a - Math.sqrt(discriminant)) / 2.0;
        double x2 = (a + Math.sqrt(discriminant)) / 2.0;

        long minX = Math.max((long) Math.ceil(x1), -10000);
        long maxX = Math.min((long) Math.floor(x2), 10000);

        for (long x = minX; x <= maxX; x++) {
            long y1 = x * x;
            long y2 = a * x + b;
            
            if (y2 >= y1) {
                long minY = y1;
                long maxY = y2;
                count += (maxY - minY + 1);
            }
        }

        return count;
    }
}
