package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ78 {

    public ResponseDto Question78() {
        ResponseDto responseDto = new ResponseDto();
        int limit = 100000;
        int[] p = new int[limit + 1];
        p[0] = 1;
        for (int i = 1; i <= limit; i++) {
            for (int k = 1; ; k++) {
                int g1 = k * (3 * k - 1) / 2;
                int g2 = -k * (3 * -k - 1) / 2;
                if (g1 > i) break;
                int term1 = p[i - g1];
                int term2 = (g2 <= i) ? p[i - g2] : 0;
                if (k % 2 == 1) {
                    p[i] = (p[i] + term1 + term2) % 1000000;
                } else {
                    p[i] = (p[i] - term1 - term2 + 2000000) % 1000000;
                }
            }
            if (p[i] == 0) {
                responseDto.setAnswer(i);
                break;
            }
        }
        return responseDto;
    }
}
