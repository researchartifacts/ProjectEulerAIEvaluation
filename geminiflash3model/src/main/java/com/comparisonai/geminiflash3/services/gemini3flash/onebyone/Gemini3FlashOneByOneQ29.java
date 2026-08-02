package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

@Service
public class Gemini3FlashOneByOneQ29 {

    public ResponseDto Question29() {
        ResponseDto responseDto = new ResponseDto();
        Set<BigInteger> distinct = new HashSet<>();
        for (int a = 2; a <= 100; a++) {
            for (int b = 2; b <= 100; b++) {
                distinct.add(BigInteger.valueOf(a).pow(b));
            }
        }
        responseDto.setAnswer(distinct.size());
        return responseDto;
    }
}
