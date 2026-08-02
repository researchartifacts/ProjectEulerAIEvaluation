package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ100 {

    public ResponseDto Question100() {
        ResponseDto responseDto = new ResponseDto();
        long limit = 1000000000000L;
        long b = 15, n = 21;
        while (n < limit) {
            long nextB = 3 * b + 2 * n - 2;
            long nextN = 4 * b + 3 * n - 3;
            b = nextB;
            n = nextN;
        }
        responseDto.setAnswer(b);
        return responseDto;
    }
}
