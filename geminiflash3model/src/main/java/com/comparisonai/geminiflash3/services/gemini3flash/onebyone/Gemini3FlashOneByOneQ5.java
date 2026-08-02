package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ5 {

    public ResponseDto Question5() {
        ResponseDto responseDto = new ResponseDto();
        long result = 1;
        for (int i = 1; i <= 20; i++) {
            result = lcm(result, i);
        }
        responseDto.setAnswer(result);
        return responseDto;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            a %= b;
            long temp = a;
            a = b;
            b = temp;
        }
        return a;
    }

    private long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }
}
