package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ317 {

    public ResponseDto Question317() {
        ResponseDto responseDto = new ResponseDto();
        
        double h = 100.0;
        double v = 20.0;
        double g = 9.81;
        
        // H = h + v^2 / (2g)
        // V = (PI * v^2 * H^2) / g
        
        double H = h + (v * v) / (2 * g);
        double volume = (Math.PI * v * v * H * H) / g;
        
        responseDto.setAnswer(Math.round(volume * 10000.0) / 10000.0);
        return responseDto;
    }
}
