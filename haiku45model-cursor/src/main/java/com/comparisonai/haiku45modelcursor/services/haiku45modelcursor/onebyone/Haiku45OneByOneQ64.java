package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 64
 */
@Service
public class Haiku45OneByOneQ64 {

    public ResponseDto Question64() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: All square roots are periodic when written as continued fractions and can be ...
        // Generated logic to solve the problem:
        
        int count = 0;
        
        for (int n = 2; n <= 10000; n++) {
            // Skip perfect squares
            int sqrtN = (int) Math.sqrt(n);
            if (sqrtN * sqrtN == n) {
                continue;
            }
            
            // Calculate period of continued fraction for sqrt(n)
            int period = getContinuedFractionPeriod(n);
            if (period % 2 == 1) {
                count++;
            }
        }
        
        Object result = count;
        
        responseDto.setAnswer(result);
        return responseDto;
    }
    
    private int getContinuedFractionPeriod(int n) {
        int a0 = (int) Math.sqrt(n);
        int m = 0;
        int d = 1;
        int a = a0;
        
        int period = 0;
        while (true) {
            m = d * a - m;
            d = (n - m * m) / d;
            a = (a0 + m) / d;
            period++;
            
            if (a == 2 * a0) {
                break;
            }
        }
        
        return period;
    }
}
