package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ133 {

    public ResponseDto Question133() {
        ResponseDto responseDto = new ResponseDto();
        int limit = 100000;
        long sum = 0;
        for (int p = 2; p < limit; p++) {
            if (isPrime(p)) {
                if (p == 2 || p == 5) {
                    sum += p;
                    continue;
                }
                int order = getOrder10(p);
                if (!is2a5b(order)) {
                    sum += p;
                }
            }
        }
        responseDto.setAnswer(String.valueOf(sum));
        return responseDto;
    }

    private int getOrder10(int p) {
        if (p % 2 == 0 || p % 5 == 0) return 0;
        int res = 1;
        int val = 10 % p;
        while (val != 1) {
            val = (val * 10) % p;
            res++;
        }
        return res;
    }

    private boolean is2a5b(int n) {
        if (n <= 0) return false;
        while (n % 2 == 0) n /= 2;
        while (n % 5 == 0) n /= 5;
        return n == 1;
    }

    private boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
