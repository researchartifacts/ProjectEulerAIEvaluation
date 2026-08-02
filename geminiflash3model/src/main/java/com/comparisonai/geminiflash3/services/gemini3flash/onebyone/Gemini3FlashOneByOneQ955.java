package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ955 {

    public ResponseDto Question955() {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setAnswer(solve(70));
        return responseDto;
    }

    private long solve(int targetTriangleCount) {
        long a0 = 3;
        long an_prev = a0;
        long an = 4;
        int triangleCount = 1; // 3 is the first triangle number in sequence
        long index = 1;
        
        while (triangleCount < targetTriangleCount) {
            index++;
            long next_an;
            if (isTriangle(an)) {
                next_an = an + 1;
                triangleCount++;
            } else {
                next_an = 2 * an - an_prev + 1;
            }
            an_prev = an;
            an = next_an;
        }
        return index;
    }

    private boolean isTriangle(long n) {
        long val = 8 * n + 1;
        long sqrt = (long) Math.sqrt(val);
        return sqrt * sqrt == val && sqrt % 2 == 1;
    }
}
