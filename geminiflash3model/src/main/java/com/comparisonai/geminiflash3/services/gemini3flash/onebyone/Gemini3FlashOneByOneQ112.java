package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ112 {

    public ResponseDto Question112() {
        ResponseDto responseDto = new ResponseDto();
        int bouncyCount = 0;
        for (int n = 1; ; n++) {
            if (isBouncy(n)) {
                bouncyCount++;
            }
            if (bouncyCount * 100 == 99 * n) {
                responseDto.setAnswer(String.valueOf(n));
                break;
            }
        }
        return responseDto;
    }

    private boolean isBouncy(int n) {
        boolean increasing = true;
        boolean decreasing = true;
        int lastDigit = n % 10;
        n /= 10;
        while (n > 0) {
            int digit = n % 10;
            if (digit > lastDigit) increasing = false;
            if (digit < lastDigit) decreasing = false;
            if (!increasing && !decreasing) return true;
            lastDigit = digit;
            n /= 10;
        }
        return false;
    }
}
