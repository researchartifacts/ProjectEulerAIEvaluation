package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ131 {

    public ResponseDto Question131() {
        ResponseDto responseDto = new ResponseDto();
        int limit = 1000000;
        int count = 0;
        for (int x = 1; ; x++) {
            long p = 3L * x * x + 3L * x + 1;
            if (p >= limit) break;
            if (isPrime(p)) {
                count++;
            }
        }
        responseDto.setAnswer(String.valueOf(count));
        return responseDto;
    }

    private boolean isPrime(long n) {
        if (n < 2) return false;
        if (n == 2 || n == 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        for (long i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }
}
