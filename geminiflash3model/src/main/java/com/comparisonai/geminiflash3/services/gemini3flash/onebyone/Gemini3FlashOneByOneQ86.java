package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ86 {

    public ResponseDto Question86() {
        ResponseDto responseDto = new ResponseDto();
        int count = 0;
        for (int m = 1; ; m++) {
            for (int wh = 2; wh <= 2 * m; wh++) {
                double dist = Math.sqrt(m * m + wh * wh);
                if (dist == (int) dist) {
                    if (wh <= m) count += wh / 2;
                    else count += (m - (wh + 1) / 2 + 1);
                }
            }
            if (count > 1000000) {
                responseDto.setAnswer(m);
                break;
            }
        }
        return responseDto;
    }
}
