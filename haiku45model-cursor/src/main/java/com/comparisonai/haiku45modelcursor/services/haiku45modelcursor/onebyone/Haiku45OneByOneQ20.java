package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;

/**
 * Problem 20: Factorial digit sum
 */
@Service
public class Haiku45OneByOneQ20 {

    public ResponseDto Question20() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Find the sum of the digits in 100!
        
        BigInteger factorial = BigInteger.ONE;
        for (int i = 2; i <= 100; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        
        String factorialStr = factorial.toString();
        long digitSum = 0;
        
        for (char digit : factorialStr.toCharArray()) {
            digitSum += Character.getNumericValue(digit);
        }
        
        Object result = digitSum;
        responseDto.setAnswer(result);
        return responseDto;
    }
}
