package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 1
 */
@Service
public class Haiku45OneByOneQ1 {

    public ResponseDto Question1() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Find the sum of all the multiples of 3 or 5 below 1000
        // Generated logic to solve the problem:
        long sum = 0;
        for (int i = 1; i < 1000; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }
        Object result = sum;
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
