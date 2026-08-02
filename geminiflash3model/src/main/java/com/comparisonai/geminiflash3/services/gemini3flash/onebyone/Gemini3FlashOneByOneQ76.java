package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ76 {

    public ResponseDto Question76() {
        ResponseDto responseDto = new ResponseDto();
        int target = 100;
        long[] ways = new long[target + 1];
        ways[0] = 1;
        for (int i = 1; i < target; i++) {
            for (int j = i; j <= target; j++) {
                ways[j] += ways[j - i];
            }
        }
        responseDto.setAnswer(ways[target]);
        return responseDto;
    }
}
