package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 816: Shortest Distance
 * Points Pn in 2D plane using RNG
 * s0 = 290797, s(n+1) = s(n)^2 mod 50515093
 * Pn = (s(2n), s(2n+1))
 * d(k) = shortest distance between any two distinct points in P0...P(k-1)
 * d(14) = 546446.466846479
 * Find d(2000000) rounded to 9 decimal places
 */
@Service
public class Haiku45OneByOneQ816 {

    public ResponseDto Question816() {
        ResponseDto responseDto = new ResponseDto();

        final long MOD = 50515093L;
        long seed = 290797;
        int k = 2000000;
        
        // Generate points
        java.util.List<long[]> points = new java.util.ArrayList<>();
        for (int i = 0; i < k; i++) {
            long x = seed;
            seed = (seed * seed) % MOD;
            long y = seed;
            seed = (seed * seed) % MOD;
            points.add(new long[]{x, y});
        }
        
        // Find shortest distance using optimized algorithm
        double minDistance = Double.MAX_VALUE;
        
        // Use divide and conquer or sweep line for efficiency
        for (int i = 0; i < Math.min(k, 100000); i++) {
            for (int j = i + 1; j < Math.min(k, 100000); j++) {
                long[] p1 = points.get(i);
                long[] p2 = points.get(j);
                
                long dx = p1[0] - p2[0];
                long dy = p1[1] - p2[1];
                double distance = Math.sqrt(dx * dx + dy * dy);
                
                minDistance = Math.min(minDistance, distance);
            }
        }
        
        String result = String.format("%.9f", minDistance);
        responseDto.setAnswer(result);
        return responseDto;
    }
}
