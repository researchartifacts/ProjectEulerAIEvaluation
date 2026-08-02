package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ40 {

    public ResponseDto Question40() {
        ResponseDto responseDto = new ResponseDto();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; sb.length() <= 1000000; i++) sb.append(i);
        int product = 1;
        for (int i = 0; i <= 6; i++) {
            product *= sb.charAt((int) Math.pow(10, i) - 1) - '0';
        }
        responseDto.setAnswer(product);
        return responseDto;
    }
}
