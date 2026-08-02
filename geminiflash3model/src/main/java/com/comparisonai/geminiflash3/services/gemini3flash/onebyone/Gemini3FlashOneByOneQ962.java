package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ962 {

    public ResponseDto Question962() {
        ResponseDto responseDto = new ResponseDto();
        int maxPerimeter = 1000000;
        responseDto.setAnswer(solve(maxPerimeter));
        return responseDto;
    }

    private long solve(int maxPerimeter) {
        long count = 0;
        for (int a = 1; a <= maxPerimeter / 2; a++) {
            for (int b = a; b <= (maxPerimeter - a) / 2; b++) {
                int maxC = Math.min(a + b - 1, maxPerimeter - a - b);
                for (int c = b; c <= maxC; c++) {
                    // Triangle ABC with sides c <= b <= a (standard notation usually uses a,b,c for sides)
                    // The problem says BC <= AC <= AB. Let a=BC, b=AC, c=AB. So a <= b <= c.
                    // CE has integral length.
                    // CE = (a * c) / (a + b)
                    if ((long) a * c % (a + b) == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
