package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ39 {

    public ResponseDto Question39() {
        ResponseDto responseDto = new ResponseDto();
        int maxP = 0;
        int maxSolutions = 0;
        for (int p = 2; p <= 1000; p += 2) {
            int solutions = 0;
            for (int a = 1; a < p / 3; a++) {
                if ((p * (p - 2 * a)) % (2 * (p - a)) == 0) solutions++;
            }
            if (solutions > maxSolutions) {
                maxSolutions = solutions;
                maxP = p;
            }
        }
        responseDto.setAnswer(maxP);
        return responseDto;
    }
}
