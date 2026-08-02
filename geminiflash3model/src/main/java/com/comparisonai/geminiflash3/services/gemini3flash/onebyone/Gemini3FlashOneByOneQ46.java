package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ46 {

    public ResponseDto Question46() {
        ResponseDto responseDto = new ResponseDto();
        for (int i = 9; ; i += 2) {
            if (isPrime(i)) continue;
            boolean found = false;
            for (int s = 1; 2 * s * s < i; s++) {
                if (isPrime(i - 2 * s * s)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                responseDto.setAnswer(i);
                break;
            }
        }
        return responseDto;
    }

    private boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i * i <= n; i++) if (n % i == 0) return false;
        return true;
    }
}
