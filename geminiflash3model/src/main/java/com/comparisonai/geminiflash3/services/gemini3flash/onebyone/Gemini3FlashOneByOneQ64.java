package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ64 {

    public ResponseDto Question64() {
        ResponseDto responseDto = new ResponseDto();
        int count = 0;
        for (int i = 2; i <= 10000; i++) {
            if (getPeriod(i) % 2 != 0) count++;
        }
        responseDto.setAnswer(count);
        return responseDto;
    }

    private int getPeriod(int n) {
        int r = (int) Math.sqrt(n);
        if (r * r == n) return 0;
        int m = 0, d = 1, a = r;
        int count = 0;
        while (a != 2 * r) {
            m = d * a - m;
            d = (n - m * m) / d;
            a = (r + m) / d;
            count++;
        }
        return count;
    }
}
