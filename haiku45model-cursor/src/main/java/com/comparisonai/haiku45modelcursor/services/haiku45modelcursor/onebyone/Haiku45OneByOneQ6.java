package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 6
 */
@Service
public class Haiku45OneByOneQ6 {

    public ResponseDto Question6() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Find the difference between sum of squares and square of sum for first 100 natural numbers
        // Generated logic to solve the problem:
        long sumOfSquares = 0;
        long sum = 0;
        for (int i = 1; i <= 100; i++) {
            sumOfSquares += i * i;
            sum += i;
        }
        long squareOfSum = sum * sum;
        long difference = squareOfSum - sumOfSquares;
        Object result = difference;
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
