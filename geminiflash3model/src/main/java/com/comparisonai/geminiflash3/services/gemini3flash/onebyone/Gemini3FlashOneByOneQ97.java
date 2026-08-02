package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class Gemini3FlashOneByOneQ97 {

    public ResponseDto Question97() {
        ResponseDto responseDto = new ResponseDto();
        BigInteger mod = BigInteger.valueOf(10000000000L);
        BigInteger res = BigInteger.valueOf(2).modPow(BigInteger.valueOf(7830457), mod);
        res = res.multiply(BigInteger.valueOf(28433)).add(BigInteger.ONE).mod(mod);
        responseDto.setAnswer(res.toString());
        return responseDto;
    }
}
