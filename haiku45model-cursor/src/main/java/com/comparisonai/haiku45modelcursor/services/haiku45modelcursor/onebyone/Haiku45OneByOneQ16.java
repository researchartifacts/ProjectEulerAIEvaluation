package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;

/**
 * Problem 16: Power digit sum
 */
@Service
public class Haiku45OneByOneQ16 {

    public ResponseDto Question16() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: What is the sum of the digits of 2^1000?
        // We need to calculate 2^1000 and sum its digits
        
        BigInteger power = BigInteger.valueOf(2).pow(1000);
        String powerStr = power.toString();
        
        long digitSum = 0;
        for (char digit : powerStr.toCharArray()) {
            digitSum += Character.getNumericValue(digit);
        }
        
        Object result = digitSum;
        responseDto.setAnswer(result);
        return responseDto;
    }
}
