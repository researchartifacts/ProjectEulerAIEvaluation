package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ139 {

    public ResponseDto Question139() {
        ResponseDto responseDto = new ResponseDto();
        long limit = 100000000;
        long count = 0;
        
        // x^2 - 2y^2 = +/- 1
        long x = 1;
        long y = 1;
        while (true) {
            long nextX = 3 * x + 4 * y;
            long nextY = 2 * x + 3 * y;
            x = nextX;
            y = nextY;
            
            // m = x+y, n = y
            // Perimeter P = 2m(m+n) = 2(x+y)(x+2y)
            long p = 2 * (x + y) * (x + 2 * y);
            if (p >= limit) break;
            count += (limit - 1) / p;
        }
        
        responseDto.setAnswer(String.valueOf(count));
        return responseDto;
    }
}
