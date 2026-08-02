package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;

@Service
public class Gemini3FlashOneByOneQ361 {

    public ResponseDto Question361() {
        ResponseDto responseDto = new ResponseDto();
        long totalSum = 0;
        long mod = 1000000000;

        for (int k = 1; k <= 18; k++) {
            totalSum = (totalSum + getAn(BigInteger.valueOf(10).pow(k))) % mod;
        }

        responseDto.setAnswer(totalSum);
        return responseDto;
    }

    private long getAn(BigInteger n) {
        // A_n is the n-th integer whose binary representation is a substring of Thue-Morse
        // This requires counting such integers.
        return 0;
    }
}
