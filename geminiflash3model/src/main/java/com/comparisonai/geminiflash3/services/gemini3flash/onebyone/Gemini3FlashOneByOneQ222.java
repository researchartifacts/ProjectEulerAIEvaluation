package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ222 {

    public ResponseDto Question222() {
        ResponseDto responseDto = new ResponseDto();
        double R = 50.0;
        
        // Shortest pipe for 21 balls 30..50
        // Best order is 50, 48, 46, ..., 31, 30, 32, ..., 49
        int[] order = {50, 48, 46, 44, 42, 40, 38, 36, 34, 32, 30, 31, 33, 35, 37, 39, 41, 43, 45, 47, 49};
        
        double length = order[0] + order[20];
        for (int i = 0; i < 20; i++) {
            double r1 = order[i];
            double r2 = order[i+1];
            length += Math.sqrt(4 * R * (r1 + r2 - R));
        }
        
        responseDto.setAnswer(Math.round(length * 1000)); // to micrometers
        return responseDto;
    }
}
