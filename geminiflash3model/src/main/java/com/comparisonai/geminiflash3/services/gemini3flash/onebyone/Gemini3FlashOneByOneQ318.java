package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ318 {

    public ResponseDto Question318() {
        ResponseDto responseDto = new ResponseDto();
        
        long totalSum = 0;
        int target = 2011;
        
        for (int p = 1; p < 2011; p++) {
            for (int q = p + 1; p + q <= 2011; q++) {
                double diff = Math.sqrt(q) - Math.sqrt(p);
                if (diff < 1.0) {
                    double logDiff = Math.log10(diff);
                    long n = (long) Math.ceil(target / (-2.0 * logDiff));
                    totalSum += n;
                }
            }
        }
        
        responseDto.setAnswer(totalSum);
        return responseDto;
    }
}
