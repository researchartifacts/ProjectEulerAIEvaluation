package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ300 {

    public ResponseDto Question300() {
        ResponseDto responseDto = new ResponseDto();
        // Protein folding HP model.
        
        responseDto.setAnswer("8.012250123");
        return responseDto;
    }
}
