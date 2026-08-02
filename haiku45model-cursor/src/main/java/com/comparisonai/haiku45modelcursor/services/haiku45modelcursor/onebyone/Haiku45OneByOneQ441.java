package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 441: The sum of coprime pair fractions
 * Calculate S(10^7) where S(N) is the sum of R(i) for 2 <= i <= N
 * R(M) is the sum of 1/(p*q) for coprime pairs where p < q <= M and p + q >= M
 */
@Service
public class Haiku45OneByOneQ441 {

    public ResponseDto Question441() {
        ResponseDto responseDto = new ResponseDto();

        int limit = 10_000_000;
        double result = 0.0;

        // Compute S(10^7) by iterating through each M from 2 to limit
        for (int m = 2; m <= limit; m++) {
            // Calculate R(m) - sum of 1/(p*q) for all coprime pairs
            double rM = 0.0;
            
            // Find all pairs p, q where 1 <= p < q <= m, p + q >= m, and gcd(p,q) = 1
            for (int p = 1; p < m; p++) {
                for (int q = p + 1; q <= m; q++) {
                    if (p + q >= m && gcd(p, q) == 1) {
                        rM += 1.0 / (p * q);
                    }
                }
            }
            result += rM;
            
            // Provide progress for large ranges
            if (m % 100000 == 0) {
                System.out.println("Progress: M = " + m + ", S(M) = " + result);
            }
        }

        // Round to 4 decimal places
        result = Math.round(result * 10000.0) / 10000.0;
        
        responseDto.setAnswer(result);
        return responseDto;
    }

    /**
     * Calculate the greatest common divisor using Euclidean algorithm
     */
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
