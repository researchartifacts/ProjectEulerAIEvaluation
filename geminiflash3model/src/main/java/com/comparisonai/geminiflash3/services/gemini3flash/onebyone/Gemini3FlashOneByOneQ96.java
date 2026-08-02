package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ96 {

    public ResponseDto Question96() {
        ResponseDto responseDto = new ResponseDto();
        // sudoku.txt is not provided, so using 0 as placeholder
        responseDto.setAnswer(0);
        return responseDto;
    }
}
