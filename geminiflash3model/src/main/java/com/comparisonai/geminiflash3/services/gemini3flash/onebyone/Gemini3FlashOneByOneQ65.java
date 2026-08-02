package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class Gemini3FlashOneByOneQ65 {

    public ResponseDto Question65() {
        ResponseDto responseDto = new ResponseDto();
        int n = 100;
        BigInteger num = BigInteger.valueOf(getA(n - 1));
        BigInteger den = BigInteger.ONE;
        for (int i = n - 2; i >= 0; i--) {
            BigInteger nextNum = BigInteger.valueOf(getA(i)).multiply(num).add(den);
            den = num;
            num = nextNum;
        }
        int sum = 0;
        for (char c : num.toString().toCharArray()) sum += c - '0';
        responseDto.setAnswer(sum);
        return responseDto;
    }

    private int getA(int i) {
        if (i == 0) return 2;
        if (i % 3 == 2) return 2 * (i / 3 + 1);
        return 1;
    }
}
