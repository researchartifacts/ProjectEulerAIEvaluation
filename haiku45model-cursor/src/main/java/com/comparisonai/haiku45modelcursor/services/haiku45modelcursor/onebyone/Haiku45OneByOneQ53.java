package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 53
 */
@Service
public class Haiku45OneByOneQ53 {

    public ResponseDto Question53() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: How many values of C(n,r) for 1 <= n <= 100 are greater than one million?
        // Generated logic to solve the problem:
        
        java.util.function.BiFunction<Integer, Integer, Long> binomial = (n, r) -> {
            if (r > n - r) r = n - r;
            long result = 1;
            for (int i = 0; i < r; i++) {
                result = result * (n - i) / (i + 1);
                if (result > 1000000) return result;
            }
            return result;
        };
        
        long count = 0;
        for (int n = 1; n <= 100; n++) {
            for (int r = 1; r <= n; r++) {
                if (binomial.apply(n, r) > 1000000) {
                    count++;
                }
            }
        }
        
        Object result = count;
        responseDto.setAnswer(result);
        return responseDto;
    }
}
