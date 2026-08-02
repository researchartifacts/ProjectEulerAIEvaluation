package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ7 {

    public ResponseDto Question7() {
        ResponseDto responseDto = new ResponseDto();
        int count = 0;
        int num = 1;
        while (count < 10001) {
            num++;
            if (isPrime(num)) {
                count++;
            }
        }
        responseDto.setAnswer(num);
        return responseDto;
    }

    private boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }
}
