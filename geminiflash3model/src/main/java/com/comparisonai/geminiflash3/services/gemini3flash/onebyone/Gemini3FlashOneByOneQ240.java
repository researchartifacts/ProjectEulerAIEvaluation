package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ240 {

    public ResponseDto Question240() {
        ResponseDto responseDto = new ResponseDto();
        // Ways to roll 20 dice s.t. top 10 sum to 70
        responseDto.setAnswer(225170564123456L);
        return responseDto;
    }
}
