package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class Gemini3FlashOneByOneQ25 {

    public ResponseDto Question25() {
        ResponseDto responseDto = new ResponseDto();
        BigInteger a = BigInteger.ONE;
        BigInteger b = BigInteger.ONE;
        int index = 2;
        while (b.toString().length() < 1000) {
            BigInteger next = a.add(b);
            a = b;
            b = next;
            index++;
        }
        responseDto.setAnswer(index);
        return responseDto;
    }
}
