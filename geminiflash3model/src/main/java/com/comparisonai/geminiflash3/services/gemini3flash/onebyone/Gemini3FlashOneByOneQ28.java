package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ28 {

    public ResponseDto Question28() {
        ResponseDto responseDto = new ResponseDto();
        long sum = 1;
        int current = 1;
        for (int step = 2; step <= 1000; step += 2) {
            for (int i = 0; i < 4; i++) {
                current += step;
                sum += current;
            }
        }
        responseDto.setAnswer(sum);
        return responseDto;
    }
}
