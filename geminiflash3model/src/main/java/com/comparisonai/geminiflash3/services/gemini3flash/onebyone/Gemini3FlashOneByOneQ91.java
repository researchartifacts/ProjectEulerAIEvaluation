package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ91 {

    public ResponseDto Question91() {
        ResponseDto responseDto = new ResponseDto();
        int limit = 50;
        int count = limit * limit * 3;
        for (int x1 = 1; x1 <= limit; x1++) {
            for (int y1 = 1; y1 <= limit; y1++) {
                int g = gcd(x1, y1);
                count += Math.min(y1 * g / x1, (limit - x1) * g / y1) * 2;
            }
        }
        responseDto.setAnswer(count);
        return responseDto;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            a %= b;
            int t = a; a = b; b = t;
        }
        return a;
    }
}
