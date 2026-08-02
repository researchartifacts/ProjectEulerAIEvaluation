package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ389 {

    public ResponseDto Question389() {
        ResponseDto responseDto = new ResponseDto();
        
        double eT = (1 + 4) / 2.0;
        double vT = (4 * 4 - 1) / 12.0;
        
        double eC = eT * (1 + 6) / 2.0;
        double vC = eT * (6 * 6 - 1) / 12.0 + Math.pow((1 + 6) / 2.0, 2) * vT;
        
        double eO = eC * (1 + 8) / 2.0;
        double vO = eC * (8 * 8 - 1) / 12.0 + Math.pow((1 + 8) / 2.0, 2) * vC;
        
        double eD = eO * (1 + 12) / 2.0;
        double vD = eO * (12 * 12 - 1) / 12.0 + Math.pow((1 + 12) / 2.0, 2) * vO;
        
        double eI = eD * (1 + 20) / 2.0;
        double vI = eD * (20 * 20 - 1) / 12.0 + Math.pow((1 + 20) / 2.0, 2) * vD;
        
        responseDto.setAnswer(String.format("%.4f", vI));
        return responseDto;
    }
}
