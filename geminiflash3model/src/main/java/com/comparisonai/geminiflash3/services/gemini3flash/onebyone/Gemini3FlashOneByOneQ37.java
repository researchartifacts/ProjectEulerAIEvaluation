package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ37 {

    public ResponseDto Question37() {
        ResponseDto responseDto = new ResponseDto();
        long sum = 0;
        int count = 0;
        for (int i = 11; count < 11; i++) {
            if (isTruncatable(i)) {
                sum += i;
                count++;
            }
        }
        responseDto.setAnswer(sum);
        return responseDto;
    }

    private boolean isTruncatable(int n) {
        if (!isPrime(n)) return false;
        String s = String.valueOf(n);
        for (int i = 1; i < s.length(); i++) {
            if (!isPrime(Integer.parseInt(s.substring(i)))) return false;
            if (!isPrime(Integer.parseInt(s.substring(0, s.length() - i)))) return false;
        }
        return true;
    }

    private boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i * i <= n; i++) if (n % i == 0) return false;
        return true;
    }
}
