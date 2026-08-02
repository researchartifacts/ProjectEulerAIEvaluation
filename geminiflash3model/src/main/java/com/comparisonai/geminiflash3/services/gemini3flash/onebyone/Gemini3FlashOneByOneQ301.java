package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ301 {

    public ResponseDto Question301() {
        ResponseDto responseDto = new ResponseDto();
        
        long nLimit = 30;
        long[] fib = new long[33];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i <= 32; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        
        // n AND (n << 1) == 0 for n <= 2^30
        // This corresponds to binary strings of length 30 with no consecutive 1s
        // Plus the case n = 2^30 which also has no consecutive 1s.
        // Number of such strings of length k is Fib(k+2).
        // For k=30, it is Fib(32).
        
        responseDto.setAnswer(fib[32]);
        return responseDto;
    }
}
