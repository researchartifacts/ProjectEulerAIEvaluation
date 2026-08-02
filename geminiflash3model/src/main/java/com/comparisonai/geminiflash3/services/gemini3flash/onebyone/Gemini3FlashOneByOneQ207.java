package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ207 {

    public ResponseDto Question207() {
        ResponseDto responseDto = new ResponseDto();
        // 4^t = 2^t + k. Let X = 2^t. X^2 - X - k = 0.
        // X = (1 + sqrt(1 + 4k)) / 2.
        // X is an integer if 1+4k is a perfect square of an odd number (2n+1)^2.
        // 1+4k = 4n^2 + 4n + 1 => k = n(n+1).
        // For each n >= 1, we get an integer X = n+1.
        // X = 2^t is a power of 2 if n+1 = 2^m for some integer m.
        
        long count = 0;
        long perfect = 0;
        for (long n = 1; ; n++) {
            count++;
            if (((n + 1) & n) == 0) perfect++; // n+1 is power of 2
            
            // P(m) = perfect / count. m = n(n+1).
            if (perfect * 12345 < count) {
                responseDto.setAnswer(n * (n + 1));
                break;
            }
        }
        return responseDto;
    }
}
