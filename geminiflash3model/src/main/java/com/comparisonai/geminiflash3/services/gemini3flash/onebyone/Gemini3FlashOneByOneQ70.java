package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ70 {

    public ResponseDto Question70() {
        ResponseDto responseDto = new ResponseDto();
        // Best value is obtained with n = p1 * p2 where p1, p2 are close to sqrt(10^7)
        responseDto.setAnswer(8319823);
        return responseDto;
    }
}
