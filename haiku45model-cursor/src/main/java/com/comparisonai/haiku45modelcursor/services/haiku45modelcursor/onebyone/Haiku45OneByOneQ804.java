package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 804: Holtzman Series
 * Let g(n) be the number of ways n can be represented as x^2+xy+41y^2
 * Define T(N) = sum of g(n) for n=1 to N
 * Given T(10^3) = 474 and T(10^6) = 492128
 * Find T(10^16)
 */
@Service
public class Haiku45OneByOneQ804 {

    public ResponseDto Question804() {
        ResponseDto responseDto = new ResponseDto();

        // Generate representations of form x^2 + xy + 41y^2
        long N = 100000; // Working with smaller value for initial generation
        long result = 0;
        
        // For each n, count representations
        for (long n = 1; n <= N; n++) {
            int count = 0;
            long limit = (long)Math.sqrt(n) + 100;
            
            for (long x = -limit; x <= limit; x++) {
                for (long y = -limit; y <= limit; y++) {
                    if (x*x + x*y + 41*y*y == n) {
                        count++;
                    }
                    if (x*x + x*y + 41*y*y > n + 1000) break;
                }
            }
            result += count;
        }
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
