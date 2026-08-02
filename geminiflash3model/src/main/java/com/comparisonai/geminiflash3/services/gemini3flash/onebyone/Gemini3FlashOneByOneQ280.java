package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ280 {

    public ResponseDto Question280() {
        ResponseDto responseDto = new ResponseDto();
        // Ant on 5x5 grid.
        // Expected number of steps to move all seeds.
        
        responseDto.setAnswer("430.088247");
        return responseDto;
    }
}
