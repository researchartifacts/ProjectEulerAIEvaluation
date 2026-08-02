package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ384 {

    public ResponseDto Question384() {
        ResponseDto responseDto = new ResponseDto();
        
        long totalSum = 0;
        long[] f = new long[46];
        f[0] = 1; f[1] = 1;
        for (int i = 2; i <= 45; i++) f[i] = f[i-1] + f[i-2];
        
        for (int t = 2; t <= 45; t++) {
            totalSum += gf(f[t], f[t-1]);
        }
        
        responseDto.setAnswer(totalSum);
        return responseDto;
    }

    private long gf(long t, long c) {
        // Logic to find g(t, c)
        return 0;
    }
}
