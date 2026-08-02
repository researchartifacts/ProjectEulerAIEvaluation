package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 914: Pythagorean Triangle in Circle
 */
@Service
public class Haiku45OneByOneQ914 {

    public ResponseDto Question914() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: F(10^18) - largest inradius of Pythagorean triangles
        // that fit inside circle with radius R without touching
        long R = 1000000000000000000L;
        
        // For a Pythagorean triple (a, b, c) with a^2 + b^2 = c^2
        // Inradius r = (a + b - c) / 2
        // Triangle fits in circle if circumradius c/2 + r <= R
        
        long maxInradius = 0;
        
        // Check Pythagorean triples
        // For primitive triples: a = m^2 - n^2, b = 2mn, c = m^2 + n^2
        for (long m = 2; m * m < R; m++) {
            for (long n = 1; n < m; n++) {
                long a = m * m - n * n;
                long b = 2 * m * n;
                long c = m * m + n * n;
                
                // Check if fits in circle (allow scaling)
                long circumradius = c / 2;
                long inradius = (a + b - c) / 2;
                
                // Scale up while still fitting
                long scaleFactor = 1;
                if (circumradius > 0) {
                    scaleFactor = Math.min(R / circumradius, R / Math.max(1, inradius));
                }
                
                long scaledInradius = inradius * scaleFactor;
                maxInradius = Math.max(maxInradius, scaledInradius);
                
                if (m > 10000000) break;
            }
        }

        responseDto.setAnswer(maxInradius);
        return responseDto;
    }
}
