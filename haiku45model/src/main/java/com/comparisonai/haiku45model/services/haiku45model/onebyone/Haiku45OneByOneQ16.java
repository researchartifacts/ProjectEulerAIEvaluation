package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;

@Service
public class Haiku45OneByOneQ16 {

    public ResponseDto Question16() {
        ResponseDto responseDto = new ResponseDto();
        BigInteger powerOfTwo = BigInteger.valueOf(2).pow(1000);
        String powerStr = powerOfTwo.toString();
        long digitSum = 0;
        for (char digit : powerStr.toCharArray()) {
            digitSum += Character.getNumericValue(digit);
        }
        responseDto.setAnswer(digitSum);
        return responseDto;
    }
}
