package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class Gemini3FlashOneByOneQ26 {

    public ResponseDto Question26() {
        ResponseDto responseDto = new ResponseDto();
        int maxLen = 0;
        int result = 0;
        for (int d = 1; d < 1000; d++) {
            int len = getCycleLen(d);
            if (len > maxLen) {
                maxLen = len;
                result = d;
            }
        }
        responseDto.setAnswer(result);
        return responseDto;
    }

    private int getCycleLen(int d) {
        Map<Integer, Integer> remainders = new HashMap<>();
        int rem = 1;
        int pos = 0;
        while (rem != 0 && !remainders.containsKey(rem)) {
            remainders.put(rem, pos++);
            rem = (rem * 10) % d;
        }
        return rem == 0 ? 0 : pos - remainders.get(rem);
    }
}
