package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ108 {

    public ResponseDto Question108() {
        ResponseDto responseDto = new ResponseDto();
        // 1/x + 1/y = 1/n  => n(x+y) = xy => xy - nx - ny = 0 => (x-n)(y-n) = n^2
        // Number of solutions is (d(n^2) + 1) / 2
        for (int n = 1; ; n++) {
            if ((countDivisors(n * n) + 1) / 2 > 1000) {
                responseDto.setAnswer(String.valueOf(n));
                break;
            }
        }
        return responseDto;
    }

    private int countDivisors(long n) {
        int count = 1;
        for (int i = 2; i * i <= n; i++) {
            int exponent = 0;
            while (n % i == 0) {
                exponent++;
                n /= i;
            }
            count *= (exponent + 1);
        }
        if (n > 1) count *= 2;
        return count;
    }
}
