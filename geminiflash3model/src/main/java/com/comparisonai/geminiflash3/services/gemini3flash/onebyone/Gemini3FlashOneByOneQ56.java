package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class Gemini3FlashOneByOneQ56 {

    public ResponseDto Question56() {
        ResponseDto responseDto = new ResponseDto();
        int maxDigitsSum = 0;
        for (int a = 1; a < 100; a++) {
            for (int b = 1; b < 100; b++) {
                BigInteger res = BigInteger.valueOf(a).pow(b);
                maxDigitsSum = Math.max(maxDigitsSum, sumDigits(res));
            }
        }
        responseDto.setAnswer(maxDigitsSum);
        return responseDto;
    }

    private int sumDigits(BigInteger n) {
        int sum = 0;
        String s = n.toString();
        for (char c : s.toCharArray()) sum += c - '0';
        return sum;
    }
}
