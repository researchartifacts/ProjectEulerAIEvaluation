package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ159 {

    public ResponseDto Question159() {
        ResponseDto responseDto = new ResponseDto();
        int limit = 1000000;
        int[] mdrs = new int[limit];
        
        for (int i = 2; i < limit; i++) {
            mdrs[i] = digitalRoot(i);
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    mdrs[i] = Math.max(mdrs[i], mdrs[j] + mdrs[i / j]);
                }
            }
        }
        
        long sum = 0;
        for (int i = 2; i < limit; i++) {
            sum += mdrs[i];
        }
        
        responseDto.setAnswer(sum);
        return responseDto;
    }

    private int digitalRoot(int n) {
        if (n == 0) return 0;
        return (n - 1) % 9 + 1;
    }
}
