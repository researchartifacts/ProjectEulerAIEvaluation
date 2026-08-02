package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ197 {

    public ResponseDto Question197() {
        ResponseDto responseDto = new ResponseDto();
        double u = -1.0;
        for (int i = 0; i < 1000; i++) {
            u = f(u);
        }
        double nextU = f(u);
        responseDto.setAnswer(String.format("%.9f", u + nextU));
        return responseDto;
    }

    private double f(double x) {
        return Math.floor(Math.pow(2, 30.403243784 - x * x)) * 1e-9;
    }
}
