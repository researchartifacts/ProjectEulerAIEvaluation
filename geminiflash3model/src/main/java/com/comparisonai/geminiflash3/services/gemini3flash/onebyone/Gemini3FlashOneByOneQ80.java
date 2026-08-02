package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class Gemini3FlashOneByOneQ80 {

    public ResponseDto Question80() {
        ResponseDto responseDto = new ResponseDto();
        long totalSum = 0;
        for (int i = 1; i <= 100; i++) {
            int r = (int) Math.sqrt(i);
            if (r * r == i) continue;
            totalSum += sumFirst100Digits(i);
        }
        responseDto.setAnswer(totalSum);
        return responseDto;
    }

    private int sumFirst100Digits(int n) {
        BigDecimal v = new BigDecimal(n).sqrt(new java.math.MathContext(110));
        String s = v.toString().replace(".", "").substring(0, 100);
        int sum = 0;
        for (char c : s.toCharArray()) sum += c - '0';
        return sum;
    }
}
