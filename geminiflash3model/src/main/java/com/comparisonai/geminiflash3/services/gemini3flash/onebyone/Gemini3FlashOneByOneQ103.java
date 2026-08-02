package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ103 {

    public ResponseDto Question103() {
        ResponseDto responseDto = new ResponseDto();
        // The optimum set for n=6 is {11, 18, 19, 20, 22, 25}
        // Applying the rule for n=7: b = 20 (middle of n=6)
        // B = {20, 11+20, 18+20, 19+20, 20+20, 22+20, 25+20}
        // B = {20, 31, 38, 39, 40, 42, 45}
        // We need to find the optimum set for n=7. 
        // Based on the problem description, the optimum set for n=7 is 20313839404245.
        responseDto.setAnswer("20313839404245");
        return responseDto;
    }
}
