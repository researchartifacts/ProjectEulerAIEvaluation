package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ323 {

    public ResponseDto Question323() {
        ResponseDto responseDto = new ResponseDto();
        
        double expectedN = 0;
        for (int k = 1; k < 200; k++) {
            expectedN += (1.0 - Math.pow(1.0 - Math.pow(0.5, k), 32));
        }
        
        responseDto.setAnswer(Math.round(expectedN * 1e10) / 1e10);
        return responseDto;
    }
}
