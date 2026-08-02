package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 2
 */
@Service
public class Haiku45OneByOneQ2 {

    public ResponseDto Question2() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Find the sum of the even-valued terms in Fibonacci sequence not exceeding 4 million
        // Generated logic to solve the problem:
        long sum = 0;
        long a = 1, b = 2;
        while (b <= 4000000) {
            if (b % 2 == 0) {
                sum += b;
            }
            long next = a + b;
            a = b;
            b = next;
        }
        Object result = sum;
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
