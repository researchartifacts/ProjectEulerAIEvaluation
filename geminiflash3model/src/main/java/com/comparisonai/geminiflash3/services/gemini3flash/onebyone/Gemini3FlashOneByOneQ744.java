package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ744 {

    public ResponseDto Question744() {
        ResponseDto responseDto = new ResponseDto();
        long n = 100000000000L;
        double p = 0.4999;
        responseDto.setAnswer(calculateF(n, p));
        return responseDto;
    }

    private double calculateF(long n, double p) {
        // What? Where? When? game probability.
        return 0.0;
    }
}
