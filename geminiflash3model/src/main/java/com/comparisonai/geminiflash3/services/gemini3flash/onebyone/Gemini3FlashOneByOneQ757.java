package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ757 {

    public ResponseDto Question757() {
        ResponseDto responseDto = new ResponseDto();
        long limit = 100000000000000L;
        
        // ab = cd = N, a+b = c+d+1
        // Let a = x(x+1), b = y(y+1), then N = x(x+1)y(y+1) is a solution.
        // N = x*y*(x+1)*(y+1)
        // These are of the form n = x*y*(x+1)*(y+1)
        
        long count = 0;
        for (long x = 1; x * x * x * x <= limit; x++) {
            for (long y = x; ; y++) {
                long n = x * (x + 1) * y * (y + 1);
                if (n > limit) break;
                count++;
            }
        }
        
        responseDto.setAnswer(count);
        return responseDto;
    }
}
