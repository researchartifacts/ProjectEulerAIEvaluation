package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ190 {

    public ResponseDto Question190() {
        ResponseDto responseDto = new ResponseDto();
        long sum = 0;
        for (int m = 2; m <= 15; m++) {
            double p = 1.0;
            double denom = (double) m * (m + 1) / 2.0;
            for (int i = 1; i <= m; i++) {
                p *= Math.pow((double) i * m / denom, i);
            }
            sum += (long) p;
        }
        responseDto.setAnswer(String.valueOf(sum));
        return responseDto;
    }
}
