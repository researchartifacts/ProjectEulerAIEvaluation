package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 71
 */
@Service
public class Haiku45OneByOneQ71 {

    public ResponseDto Question71() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Find the numerator of the fraction immediately to the left of 3/7 in sorted reduced proper fractions with d <= 1,000,000
        // Generated logic to solve the problem:
        
        long bestN = 2;
        long bestD = 5;
        double target = 3.0 / 7.0;
        
        // Iterate through all possible denominators up to 1,000,000
        for (long d = 1; d <= 1000000; d++) {
            // For each denominator, find the largest numerator where n/d < 3/7
            // We need n/d < 3/7, so n < 3*d/7
            long maxN = (3 * d - 1) / 7;
            
            // Check fractions with numerators near this maximum
            for (long n = Math.max(1, maxN - 1); n <= maxN + 1; n++) {
                if (n < d && gcd(n, d) == 1) {
                    double frac = (double) n / d;
                    if (frac < target) {
                        // Check if this is closer to 3/7 than our current best
                        if (frac > (double) bestN / bestD) {
                            bestN = n;
                            bestD = d;
                        }
                    }
                }
            }
        }
        
        Object result = bestN;
        
        responseDto.setAnswer(result);
        return responseDto;
    }
    
    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
