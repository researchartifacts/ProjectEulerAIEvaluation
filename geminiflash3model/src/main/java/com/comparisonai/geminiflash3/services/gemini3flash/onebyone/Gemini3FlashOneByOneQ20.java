package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class Gemini3FlashOneByOneQ20 {

    public ResponseDto Question20() {
        ResponseDto responseDto = new ResponseDto();
        BigInteger fact = BigInteger.ONE;
        for (int i = 1; i <= 100; i++) {
            fact = fact.multiply(BigInteger.valueOf(i));
        }
        String s = fact.toString();
        int sum = 0;
        for (char c : s.toCharArray()) {
            sum += Character.getNumericValue(c);
        }
        responseDto.setAnswer(sum);
        return responseDto;
    }
}
