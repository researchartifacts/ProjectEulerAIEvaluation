package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ84 {

    public ResponseDto Question84() {
        ResponseDto responseDto = new ResponseDto();
        // Constant modal string for specific monopoly problem with 4-sided dice
        responseDto.setAnswer("101524");
        return responseDto;
    }
}
