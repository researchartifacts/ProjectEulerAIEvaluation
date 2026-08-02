package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class Gemini3FlashOneByOneQ57 {

    public ResponseDto Question57() {
        ResponseDto responseDto = new ResponseDto();
        int count = 0;
        BigInteger n = BigInteger.valueOf(3);
        BigInteger d = BigInteger.valueOf(2);
        for (int i = 0; i < 1000; i++) {
            if (n.toString().length() > d.toString().length()) count++;
            BigInteger nextN = n.add(d.multiply(BigInteger.valueOf(2)));
            BigInteger nextD = n.add(d);
            n = nextN;
            d = nextD;
        }
        responseDto.setAnswer(count);
        return responseDto;
    }
}
