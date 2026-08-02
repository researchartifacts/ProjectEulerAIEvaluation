package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ795 {

    public ResponseDto Question795() {
        ResponseDto responseDto = new ResponseDto();
        int N = 12345678;
        
        // g(n) = Sum_{i=1}^n (-1)^i * gcd(n, i^2).
        
        long sumG = 0;
        
        responseDto.setAnswer(sumG);
        return responseDto;
    }
}
