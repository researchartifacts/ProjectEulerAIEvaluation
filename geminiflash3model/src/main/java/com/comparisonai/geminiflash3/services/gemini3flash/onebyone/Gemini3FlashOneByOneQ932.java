package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ932 {

    public ResponseDto Question932() {
        ResponseDto responseDto = new ResponseDto();
        long sum = 0;
        for (int n = 1; n <= 16; n++) {
            for (int split = 1; split < n; split++) {
                long start = (long) Math.pow(10, split - 1);
                long end = (long) Math.pow(10, split);
                for (long a = start; a < end; a++) {
                    // (a+b)^2 = a * 10^(n-split) + b
                    // (a+b)^2 - b = a * 10^(n-split)
                    // Let x = a+b, then x^2 - (x-a) = a * 10^(digits_of_b)
                    // x^2 - x + a = a * 10^(n-split)
                }
            }
        }
        responseDto.setAnswer(sum);
        return responseDto;
    }
}
