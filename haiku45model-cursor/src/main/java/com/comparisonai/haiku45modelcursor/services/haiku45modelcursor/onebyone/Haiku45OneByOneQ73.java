package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 73
 */
@Service
public class Haiku45OneByOneQ73 {

    public ResponseDto Question73() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Count reduced proper fractions between 1/3 and 1/2 with d <= 12,000
        // Generated logic to solve the problem:
        
        long count = 0;
        
        for (long d = 1; d <= 12000; d++) {
            // We need n/d where 1/3 < n/d < 1/2
            // From 1/3 < n/d: n > d/3
            // From n/d < 1/2: n < d/2
            long minN = d / 3 + 1;
            long maxN = (d - 1) / 2;
            
            for (long n = minN; n <= maxN; n++) {
                if (n < d && gcd(n, d) == 1) {
                    count++;
                }
            }
        }
        
        Object result = count;
        
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
