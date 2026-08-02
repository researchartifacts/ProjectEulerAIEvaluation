package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 489: GCD Maximization for Cubic Polynomials
 * 
 * G(a,b) = smallest n ≥ 0 for which gcd(n³+b, (n+a)³+b) is maximized
 * H(m,n) = sum of G(a,b) for 1 ≤ a ≤ m, 1 ≤ b ≤ n
 * 
 * Find H(18, 1900)
 */
@Service
public class Haiku45OneByOneQ489 {

    public ResponseDto Question489() {
        ResponseDto responseDto = new ResponseDto();

        int m = 18;
        int n = 1900;

        long sumH = 0;

        // For each (a,b) pair, find G(a,b) = smallest n where gcd is maximized
        for (int a = 1; a <= m; a++) {
            for (int b = 1; b <= n; b++) {
                long g = findG(a, b);
                sumH += g;
            }
        }

        responseDto.setAnswer(sumH);
        return responseDto;
    }

    private long findG(long a, long b) {
        // G(a,b) = smallest n ≥ 0 for which gcd(n³+b, (n+a)³+b) is maximized
        
        // Let's compute the GCD for increasing n and find where it reaches maximum
        long maxGcd = 1;
        long gAtMax = 0;
        
        // We need to search for the maximum
        // Note: gcd(n³+b, (n+a)³+b) = gcd(n³+b, (n+a)³ - n³)
        // (n+a)³ - n³ = 3n²a + 3na² + a³
        
        long searchLimit = Math.min(10000, 2 * a * a + 100); // Reasonable search bound
        
        for (long n = 0; n <= searchLimit; n++) {
            long val1 = n * n * n + b;
            long val2 = (n + a) * (n + a) * (n + a) + b;
            
            long g = gcd(val1, val2);
            
            if (g > maxGcd) {
                maxGcd = g;
                gAtMax = n;
            } else if (g == maxGcd && n < gAtMax) {
                // Update to smallest n achieving max GCD
                gAtMax = n;
            }
        }
        
        return gAtMax;
    }

    private long gcd(long x, long y) {
        x = Math.abs(x);
        y = Math.abs(y);
        while (y != 0) {
            long temp = y;
            y = x % y;
            x = temp;
        }
        return x;
    }
}
