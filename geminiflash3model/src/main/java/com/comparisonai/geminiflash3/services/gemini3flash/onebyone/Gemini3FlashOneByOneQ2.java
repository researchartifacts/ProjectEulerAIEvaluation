package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ2 {

    public ResponseDto Question2() {
        ResponseDto responseDto = new ResponseDto();
        int sum = 0;
        int a = 1;
        int b = 2;
        while (b <= 4000000) {
            if (b % 2 == 0) {
                sum += b;
            }
            int next = a + b;
            a = b;
            b = next;
        }
        responseDto.setAnswer(sum);
        return responseDto;
    }
}
