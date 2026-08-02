package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ173 {

    public ResponseDto Question173() {
        ResponseDto responseDto = new ResponseDto();
        // Square laminae with up to 1,000,000 tiles.
        // A lamina with outer side s and inner hole side h (s-h >= 2, both even or both odd).
        // Tiles t = s^2 - h^2.
        long total = 0;
        int limit = 1000000;
        for (long s = 3; s <= (limit / 4) + 1; s++) {
            for (long h = s - 2; h >= 1; h -= 2) {
                if (s * s - h * h <= limit) {
                    total++;
                } else {
                    break;
                }
            }
        }
        responseDto.setAnswer(String.valueOf(total));
        return responseDto;
    }
}
