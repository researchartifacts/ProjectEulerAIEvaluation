package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ223 {

    public ResponseDto Question223() {
        ResponseDto responseDto = new ResponseDto();
        long limit = 25_000_000;
        long count = (limit - 1) / 2; // a=1 cases: 1, k, k triangles

        for (long a = 2; a <= limit / 3; a++) {
            long a2_minus_1 = a * a - 1;
            for (long k = 1; k * k <= a2_minus_1; k++) {
                if (a2_minus_1 % k == 0) {
                    long sum = a2_minus_1 / k;
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
