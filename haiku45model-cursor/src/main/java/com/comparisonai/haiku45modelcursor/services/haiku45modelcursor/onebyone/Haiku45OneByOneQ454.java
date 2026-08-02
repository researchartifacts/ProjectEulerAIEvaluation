package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 454
 * Diophantine equation: 1/x + 1/y = 1/n
 * Find F(10^12) = count of solutions with x < y <= L
 */
@Service
public class Haiku45OneByOneQ454 {

    public ResponseDto Question454() {
        ResponseDto responseDto = new ResponseDto();
        
        long limit = 1_000_000_000_000L;
        
        // Equation: 1/x + 1/y = 1/n
        // Rearranging: y = nx/(x-n)
        // For positive integer solutions: x > n and (x-n) divides nx
        // Also need x < y, which means x < nx/(x-n), so x^2 - nx < nx, so x(x-2n) < 0
        // Since x > 0, we need x < 2n
        // So: n < x < 2n
        
        long totalSolutions = 0;
        
        // For each possible n value, count valid x values
        for (long n = 1; n * n <= limit; n++) {
            // x must be in range (n, 2n) and y <= limit
            // y = nx/(x-n) <= limit
            // nx/(x-n) <= limit
            // nx <= limit(x-n)
            // nx <= limit*x - limit*n
            // nx - limit*x <= -limit*n
            // x(n - limit) <= -limit*n
            // x >= limit*n/(limit - n)
            
            // For each valid x in range (n, 2n)
            for (long x = n + 1; x < 2 * n && x <= limit; x++) {
                if ((n * x) % (x - n) == 0) {
                    long y = (n * x) / (x - n);
                    if (x < y && y <= limit) {
                        totalSolutions++;
                    }
                }
            }
        }
        
        responseDto.setAnswer(totalSolutions);
        return responseDto;
    }
}
