package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ69 {

    public ResponseDto Question69() {
        ResponseDto responseDto = new ResponseDto();
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23};
        long result = 1;
        for (int p : primes) {
            if (result * p > 1000000) break;
            result *= p;
        }
        responseDto.setAnswer(result);
        return responseDto;
    }
}
