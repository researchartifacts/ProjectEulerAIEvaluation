package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ380 {

    public ResponseDto Question380() {
        ResponseDto responseDto = new ResponseDto();
        int m = 100;
        int n = 500;
        
        double logC = 0;
        for (int h = 0; h < m; h++) {
            for (int k = 0; k < n; k++) {
                if (h == 0 && k == 0) continue;
                logC += Math.log10(4 - 2 * Math.cos(Math.PI * h / m) - 2 * Math.cos(Math.PI * k / n));
            }
        }
        logC -= Math.log10(m * n);
        
        double exponent = Math.floor(logC);
        double mantissa = Math.pow(10, logC - exponent);
        
        String result = String.format("%.4fe%d", mantissa, (int) exponent);
        responseDto.setAnswer(result);
        return responseDto;
    }
}
