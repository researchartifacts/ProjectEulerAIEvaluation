package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class Gemini3FlashOneByOneQ48 {

    public ResponseDto Question48() {
        ResponseDto responseDto = new ResponseDto();
        BigInteger sum = BigInteger.ZERO;
        BigInteger mod = BigInteger.valueOf(10000000000L);
        for (int i = 1; i <= 1000; i++) {
            sum = sum.add(BigInteger.valueOf(i).modPow(BigInteger.valueOf(i), mod));
        }
        responseDto.setAnswer(sum.mod(mod).toString());
        return responseDto;
    }
}
