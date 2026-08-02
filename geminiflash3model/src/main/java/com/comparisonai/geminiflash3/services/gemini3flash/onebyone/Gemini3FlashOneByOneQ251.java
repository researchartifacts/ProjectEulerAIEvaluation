package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ251 {

    public ResponseDto Question251() {
        ResponseDto responseDto = new ResponseDto();
        long limit = 110_000_000;
        long count = 0;
        
        for (long k = 0; 3 * k + 2 <= limit; k++) {
            long a = 3 * k + 2;
            long val = (k + 1) * (k + 1) * (8 * k + 5);
            // b^2 * c = val, a + b + c <= limit
            // b <= sqrt(val)
            for (long b = 1; a + b + 1 <= limit; b++) {
                if (val % (b * b) == 0) {
                    long c = val / (b * b);
                    if (a + b + c <= limit) {
                        count++;
                    }
                }
            }
        }
        
        responseDto.setAnswer(count);
        return responseDto;
    }
}
