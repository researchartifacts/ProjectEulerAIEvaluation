package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;

@Service
public class Haiku45OneByOneQ56 {

    public ResponseDto Question56() {
        ResponseDto responseDto = new ResponseDto();
        BigInteger result = BigInteger.valueOf(2).pow(1000).multiply(BigInteger.valueOf(99).pow(99));
        String resultStr = result.toString();
        long digitSum = 0;
        for (char c : resultStr.toCharArray()) {
            digitSum += Character.getNumericValue(c);
        }
        responseDto.setAnswer(digitSum);
        return responseDto;
    }
}
