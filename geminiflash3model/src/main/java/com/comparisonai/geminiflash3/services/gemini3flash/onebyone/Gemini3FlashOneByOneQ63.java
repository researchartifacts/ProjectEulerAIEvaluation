package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ63 {

    public ResponseDto Question63() {
        ResponseDto responseDto = new ResponseDto();
        int count = 0;
        for (int base = 1; base <= 9; base++) {
            for (int exp = 1; ; exp++) {
                if (String.valueOf((long) Math.pow(base, exp)).length() == exp) {
                    count++;
                } else if (exp > 21) {
                    break;
                }
            }
        }
        responseDto.setAnswer(count);
        return responseDto;
    }
}
