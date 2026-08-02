package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ130 {

    public ResponseDto Question130() {
        ResponseDto responseDto = new ResponseDto();
        int target = 25;
        int count = 0;
        long sum = 0;
        int n = 2;
        while (count < target) {
            if (n % 2 != 0 && n % 5 != 0 && !isPrime(n)) {
                if ((n - 1) % A(n) == 0) {
                    sum += n;
                    count++;
                }
            }
            n++;
        }
        responseDto.setAnswer(String.valueOf(sum));
        return responseDto;
    }

    private int A(int n) {
        int k = 1;
        int r = 1;
        while (r != 0) {
            r = (r * 10 + 1) % n;
            k++;
        }
        return k;
    }

    private boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
