package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ637 {

    public ResponseDto Question637() {
        ResponseDto responseDto = new ResponseDto();
        int n = 10000000;
        
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            if (f(i, 10) == f(i, 3)) {
                sum += i;
            }
        }
        
        responseDto.setAnswer(sum);
        return responseDto;
    }

    private int f(int n, int b) {
        if (n < b) return 0;
        return 1 + f(sumDigits(n, b), b);
    }

    private int sumDigits(int n, int b) {
        int s = 0;
        while (n > 0) {
            s += n % b;
            n /= b;
        }
        return s;
    }
}
