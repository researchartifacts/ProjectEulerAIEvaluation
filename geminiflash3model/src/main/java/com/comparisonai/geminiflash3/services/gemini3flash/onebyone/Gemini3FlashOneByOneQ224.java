package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ224 {

    public ResponseDto Question224() {
        ResponseDto responseDto = new ResponseDto();
        long limit = 75_000_000;
        long count = 0;
        
        // Similar to 223: a^2 + b^2 = c^2 - 1 => a^2 + 1 = c^2 - b^2 = (c-b)(c+b)
        for (long a = 2; a <= limit / 3; a++) {
            long a2_plus_1 = a * a + 1;
            for (long k = 1; k * k < a2_plus_1; k++) {
                if (a2_plus_1 % k == 0) {
                    long sum = a2_plus_1 / k;
                    if ((sum + k) % 2 == 0) {
                        long b = (sum - k) / 2;
                        long c = (sum + k) / 2;
                        if (a <= b && a + b + c <= limit) {
                            count++;
                        }
                    }
                }
            }
        }
        
        responseDto.setAnswer(count);
        return responseDto;
    }
}
