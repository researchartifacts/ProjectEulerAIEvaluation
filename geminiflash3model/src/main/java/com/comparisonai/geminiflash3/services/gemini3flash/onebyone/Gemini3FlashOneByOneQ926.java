package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ926 {

    public ResponseDto Question926() {
        ResponseDto responseDto = new ResponseDto();
        long n = 10000000;
        long MOD = 1000000007;
        long result = 0;
        
        for (long b = 2; b <= n; b++) {
            long tempN = n;
            long count = 0;
            while (tempN > 0) {
                count += tempN / b;
                tempN /= b;
            }
            result = (result + count) % MOD;
        }
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
