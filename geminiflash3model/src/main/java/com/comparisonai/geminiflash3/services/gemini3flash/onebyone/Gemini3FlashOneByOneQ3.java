package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ3 {

    public ResponseDto Question3() {
        ResponseDto responseDto = new ResponseDto();
        long n = 600851475143L;
        long maxFactor = -1;
        for (long i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                maxFactor = i;
                n /= i;
            }
        }
        if (n > 1) {
            maxFactor = n;
        }
        responseDto.setAnswer(maxFactor);
        return responseDto;
    }
}
