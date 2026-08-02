package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class Gemini3FlashOneByOneQ221 {

    public ResponseDto Question221() {
        ResponseDto responseDto = new ResponseDto();
        int target = 150000;
        List<Long> alexandrians = new ArrayList<>();
        
        for (long p = 1; p <= 100000; p++) {
            long p2_plus_1 = p * p + 1;
            for (long d = 1; d * d <= p2_plus_1; d++) {
                if (p2_plus_1 % d == 0) {
                    alexandrians.add(p * (p + d) * (p + p2_plus_1 / d));
                }
            }
        }
        
        Collections.sort(alexandrians);
        responseDto.setAnswer(alexandrians.get(target - 1));
        return responseDto;
    }
}
