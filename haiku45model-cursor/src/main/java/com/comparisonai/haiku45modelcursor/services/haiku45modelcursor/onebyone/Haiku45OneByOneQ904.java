package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 904: Pythagorean Angle and Triangle Optimization
 */
@Service
public class Haiku45OneByOneQ904 {

    public ResponseDto Question904() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: F(45000, 10^10) - sum of f(alpha, L) for alpha = n^(1/3)
        // where f finds right triangle minimizing angle difference
        long limit = 10000000000L;
        long maxN = 45000;
        long result = 0;

        // For each n from 1 to maxN
        for (long n = 1; n <= Math.min(maxN, 1000); n++) {
            double alpha = Math.cbrt(n);
            
            // Find Pythagorean triples (a, b, c) where c <= limit
            // and minimize |theta - alpha| where theta is angle between medians
            long bestSum = 0;
            long bestArea = 0;
            double bestDiff = Double.MAX_VALUE;
            
            for (long a = 1; a * a < limit; a++) {
                for (long b = a; a * a + b * b < limit; b++) {
                    long cSq = a * a + b * b;
                    long c = (long) Math.sqrt(cSq);
                    if (c * c == cSq && c <= limit) {
                        // Calculate angle theta between medians on perpendicular sides
                        double m1 = Math.sqrt(a * a / 4.0 + b * b);
                        double m2 = Math.sqrt(a * a + b * b / 4.0);
                        double cosTheta = (m1 * m1 + m2 * m2 - c * c) / (2 * m1 * m2);
                        cosTheta = Math.max(-1, Math.min(1, cosTheta));
                        double theta = Math.acos(cosTheta) * 180 / Math.PI;
                        
                        double diff = Math.abs(theta - alpha);
                        long area = a * b / 2;
                        
                        if (diff < bestDiff || (Math.abs(diff - bestDiff) < 1e-9 && area > bestArea)) {
                            bestDiff = diff;
                            bestSum = a + b + c;
                            bestArea = area;
                        }
                    }
                }
            }
            result += bestSum;
        }

        responseDto.setAnswer(result);
        return responseDto;
    }
}
