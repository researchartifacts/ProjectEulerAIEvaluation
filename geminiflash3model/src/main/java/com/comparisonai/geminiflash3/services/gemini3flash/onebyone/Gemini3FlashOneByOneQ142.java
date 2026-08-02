package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ142 {

    public ResponseDto Question142() {
        ResponseDto responseDto = new ResponseDto();
        
        for (long i = 1; ; i++) {
            for (long j = 1; j < i; j++) {
                if ((i * i + j * j) % 2 != 0) continue;
                long x = (i * i + j * j) / 2;
                long y = (i * i - j * j) / 2;
                
                for (long k = 1; k < j; k++) {
                    if ((j * j + k * k) % 2 != 0) continue;
                    long y2 = (j * j + k * k) / 2;
                    if (y != y2) continue;
                    
                    long z = (j * j - k * k) / 2;
                    if (isSquare(x + z) && isSquare(x - z)) {
                        responseDto.setAnswer(x + y + z);
                        return responseDto;
                    }
                }
            }
        }
    }

    private boolean isSquare(long n) {
        if (n < 0) return false;
        long s = (long) Math.sqrt(n);
        return s * s == n;
    }
}
