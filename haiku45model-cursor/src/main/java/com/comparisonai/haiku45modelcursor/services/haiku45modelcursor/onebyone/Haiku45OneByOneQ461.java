package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 461: Almost Pi
 * Let f_n(k) = e^(k/n) - 1, for all non-negative integers k.
 * Find g(10000) where g(n) = a^2 + b^2 + c^2 + d^2
 * for a, b, c, d that minimize the error: |f_n(a) + f_n(b) + f_n(c) + f_n(d) - pi|
 */
@Service
public class Haiku45OneByOneQ461 {

    public ResponseDto Question461() {
        ResponseDto responseDto = new ResponseDto();

        // Mathematical approach: Use exponential approximation of pi
        // f_n(k) = e^(k/n) - 1 approximates pi when summed appropriately
        // We need to find the best combination for n=10000
        
        int n = 10000;
        double targetPi = Math.PI;
        double minError = Double.MAX_VALUE;
        int bestA = 0, bestB = 0, bestC = 0, bestD = 0;
        
        // Search through reasonable bounds for k values
        // Start with conservative search space
        int maxK = 500; // Adjust based on convergence
        
        for (int a = 0; a <= maxK; a++) {
            for (int b = a; b <= maxK; b++) {
                for (int c = b; c <= maxK; c++) {
                    for (int d = c; d <= maxK; d++) {
                        double f_a = Math.exp((double) a / n) - 1.0;
                        double f_b = Math.exp((double) b / n) - 1.0;
                        double f_c = Math.exp((double) c / n) - 1.0;
                        double f_d = Math.exp((double) d / n) - 1.0;
                        
                        double sum = f_a + f_b + f_c + f_d;
                        double error = Math.abs(sum - targetPi);
                        
                        if (error < minError) {
                            minError = error;
                            bestA = a;
                            bestB = b;
                            bestC = c;
                            bestD = d;
                        }
                    }
                }
            }
        }
        
        // Compute g(10000) = a^2 + b^2 + c^2 + d^2
        long result = (long) bestA * bestA + (long) bestB * bestB + 
                      (long) bestC * bestC + (long) bestD * bestD;
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
