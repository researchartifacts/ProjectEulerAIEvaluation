package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ45 {

    public ResponseDto Question45() {
        ResponseDto responseDto = new ResponseDto();
        // Every hexagonal number is also a triangle number.
        // H_n = n(2n-1) = T_{2n-1}
        for (long n = 144; ; n++) {
            long hn = n * (2 * n - 1);
            if (isPentagonal(hn)) {
                responseDto.setAnswer(hn);
                break;
            }
        }
        return responseDto;
    }

    private boolean isPentagonal(long x) {
        double n = (Math.sqrt(24 * x + 1) + 1) / 6.0;
        return n == (long) n;
    }
}
