package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ918 {

    public ResponseDto Question918() {
        ResponseDto responseDto = new ResponseDto();
        long N = 1000000000000L; // 10^12
        
        // S(2n) = 4 - a_n. S(10^12) = 4 - a_{5*10^11}.
        
        long result = 4 - getA(500000000000L);
        
        responseDto.setAnswer(result);
        return responseDto;
    }

    private long getA(long n) {
        if (n == 1) return 1;
        if (n % 2 == 0) return 2 * getA(n / 2);
        long m = n / 2;
        return getA(m) - 3 * getA(m + 1);
    }
}
