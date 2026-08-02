package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;

@Service
public class Haiku45OneByOneQ20 {

    public ResponseDto Question20() {
        ResponseDto responseDto = new ResponseDto();
        BigInteger factorial = BigInteger.ONE;
        for (int i = 1; i <= 100; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        String factorialStr = factorial.toString();
        long digitSum = 0;
        for (char digit : factorialStr.toCharArray()) {
            digitSum += Character.getNumericValue(digit);
        }
        responseDto.setAnswer(digitSum);
        return responseDto;
    }
}
