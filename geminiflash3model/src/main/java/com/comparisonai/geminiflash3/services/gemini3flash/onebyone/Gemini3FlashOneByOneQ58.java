package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ58 {

    public ResponseDto Question58() {
        ResponseDto responseDto = new ResponseDto();
        int primeCount = 0;
        int totalCount = 1;
        for (int side = 3; ; side += 2) {
            for (int i = 0; i < 4; i++) {
                if (isPrime(side * side - i * (side - 1))) primeCount++;
            }
            totalCount += 4;
            if ((double) primeCount / totalCount < 0.1) {
                responseDto.setAnswer(side);
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
