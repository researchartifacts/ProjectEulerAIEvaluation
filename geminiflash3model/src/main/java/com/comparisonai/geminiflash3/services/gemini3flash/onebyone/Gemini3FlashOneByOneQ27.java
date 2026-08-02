package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ27 {

    public ResponseDto Question27() {
        ResponseDto responseDto = new ResponseDto();
        int maxPrimes = 0;
        int bestProduct = 0;
        for (int a = -999; a < 1000; a++) {
            for (int b = -1000; b <= 1000; b++) {
                int n = 0;
                while (isPrime(n * n + a * n + b)) n++;
                if (n > maxPrimes) {
                    maxPrimes = n;
                    bestProduct = a * b;
                }
            }
        }
        responseDto.setAnswer(bestProduct);
        return responseDto;
    }

    private boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
