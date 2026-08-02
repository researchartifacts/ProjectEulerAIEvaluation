package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 21
 */
@Service
public class Haiku45OneByOneQ21 {

    public ResponseDto Question21() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Evaluate the sum of all amicable numbers under 10000
        // d(n) = sum of proper divisors; if d(a) = b and d(b) = a where a != b, then they are amicable
        // Generated logic to solve the problem:
        long sum = 0;
        int limit = 10000;
        
        // Calculate sum of proper divisors for each number
        int[] divisorSum = new int[limit];
        for (int i = 1; i < limit; i++) {
            divisorSum[i] = 0;
            for (int j = 1; j < i; j++) {
                if (i % j == 0) {
                    divisorSum[i] += j;
                }
            }
        }
        
        // Find amicable pairs
        for (int a = 1; a < limit; a++) {
            int b = divisorSum[a];
            if (b < limit && b != a && divisorSum[b] == a) {
                sum += a;
            }
        }
        
        Object result = sum;
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
