package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ730 {

    public ResponseDto Question730() {
        ResponseDto responseDto = new ResponseDto();
        int m = 100;
        long n = 100000000L;
        responseDto.setAnswer(calculateS(m, n));
        return responseDto;
    }

    private long calculateS(int m, long n) {
        // p^2 + q^2 + k = r^2
        return 0;
    }
}
