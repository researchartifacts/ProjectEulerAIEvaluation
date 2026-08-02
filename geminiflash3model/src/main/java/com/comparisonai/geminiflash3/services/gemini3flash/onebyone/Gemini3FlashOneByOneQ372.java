package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ372 {

    public ResponseDto Question372() {
        ResponseDto responseDto = new ResponseDto();
        long m = 2000000;
        long n = 1000000000;
        
        long result = countR(m, n);
        
        responseDto.setAnswer(result);
        return responseDto;
    }

    private long countR(long m, long n) {
        // Count (x, y) such that floor(y^2/x^2) is odd
        // sum_{x=M+1}^N (sum_{k=1}^... (count y in [sqrt(2k-1)x, sqrt(2k)x)))
        return 0;
    }
}
