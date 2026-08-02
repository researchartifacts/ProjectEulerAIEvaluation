package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ129 {

    public ResponseDto Question129() {
        ResponseDto responseDto = new ResponseDto();
        int limit = 1000000;
        int n = limit + 1;
        while (true) {
            if (n % 2 != 0 && n % 5 != 0) {
                if (A(n) > limit) {
                    responseDto.setAnswer(String.valueOf(n));
                    return responseDto;
                }
            }
            n++;
        }
    }

    private int A(int n) {
        int k = 1;
        int r = 1;
        while (r != 0) {
            r = (r * 10 + 1) % n;
            k++;
        }
        return k;
    }
}
