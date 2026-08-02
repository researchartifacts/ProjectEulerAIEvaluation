package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ85 {

    public ResponseDto Question85() {
        ResponseDto responseDto = new ResponseDto();
        int target = 2000000;
        int minDiff = target;
        int resultArea = 0;
        for (int w = 1; w <= 2000; w++) {
            for (int h = 1; h <= w; h++) {
                int rects = (w * (w + 1) / 2) * (h * (h + 1) / 2);
                int diff = Math.abs(rects - target);
                if (diff < minDiff) {
                    minDiff = diff;
                    resultArea = w * h;
                }
                if (rects > target) break;
            }
        }
        responseDto.setAnswer(resultArea);
        return responseDto;
    }
}
