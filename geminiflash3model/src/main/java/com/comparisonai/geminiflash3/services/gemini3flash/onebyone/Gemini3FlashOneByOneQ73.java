package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ73 {

    public ResponseDto Question73() {
        ResponseDto responseDto = new ResponseDto();
        int limit = 12000;
        int count = 0;
        for (int d = 2; d <= limit; d++) {
            for (int n = d / 3 + 1; n < (d + 1) / 2; n++) {
                if (gcd(n, d) == 1) count++;
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
