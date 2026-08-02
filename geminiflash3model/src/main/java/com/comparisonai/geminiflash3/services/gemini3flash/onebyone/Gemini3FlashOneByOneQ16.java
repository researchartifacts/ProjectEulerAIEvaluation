package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class Gemini3FlashOneByOneQ16 {

    public ResponseDto Question16() {
        ResponseDto responseDto = new ResponseDto();
        BigInteger n = BigInteger.valueOf(2).pow(1000);
        String s = n.toString();
        int sum = 0;
        for (char c : s.toCharArray()) {
            sum += Character.getNumericValue(c);
        }
        responseDto.setAnswer(sum);
        return responseDto;
    }
}
