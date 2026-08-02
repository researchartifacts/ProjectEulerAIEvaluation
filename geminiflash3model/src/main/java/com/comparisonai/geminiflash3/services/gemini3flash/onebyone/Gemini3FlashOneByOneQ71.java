package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ71 {

    public ResponseDto Question71() {
        ResponseDto responseDto = new ResponseDto();
        int limit = 1000000;
        int targetN = 3, targetD = 7;
        int bestN = 0, bestD = 1;
        for (int d = limit; d > 2; d--) {
            int n = (targetN * d - 1) / targetD;
            if (n * bestD > bestN * d) {
                bestN = n;
                bestD = d;
            }
        }
        responseDto.setAnswer(bestN);
        return responseDto;
    }
}
