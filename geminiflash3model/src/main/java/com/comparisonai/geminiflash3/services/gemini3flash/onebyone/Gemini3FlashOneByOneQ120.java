package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ120 {

    public ResponseDto Question120() {
        ResponseDto responseDto = new ResponseDto();
        long totalSum = 0;
        for (int a = 3; a <= 1000; a++) {
            // (a-1)^n + (a+1)^n = 2 * n * a (mod a^2) if n is odd
            // (a-1)^n + (a+1)^n = 2 (mod a^2) if n is even
            // We want to maximize 2na mod a^2.
            // 2na < a^2 => 2n < a => n_max = (a-1)/2
            // r_max = 2 * ((a-1)/2) * a
            int n_max = (a - 1) / 2;
            totalSum += 2L * n_max * a;
        }
        responseDto.setAnswer(String.valueOf(totalSum));
        return responseDto;
    }
}
