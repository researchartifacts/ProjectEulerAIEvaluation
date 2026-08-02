package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ9 {

    public ResponseDto Question9() {
        ResponseDto responseDto = new ResponseDto();
        for (int a = 1; a < 1000; a++) {
            for (int b = a + 1; b < 1000; b++) {
                int c = 1000 - a - b;
                if (c > b && a * a + b * b == c * c) {
                    responseDto.setAnswer((long) a * b * c);
                    return responseDto;
                }
            }
        }
        return responseDto;
    }
}
