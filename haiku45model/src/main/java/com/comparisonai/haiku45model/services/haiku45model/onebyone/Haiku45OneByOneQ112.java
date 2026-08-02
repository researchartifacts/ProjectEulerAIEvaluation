package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ112 {

    public ResponseDto Question112() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        // Bouncy numbers
        long bouncyCount = 0;
        for (int n = 1; n <= 100000; n++) {
            String s = String.valueOf(n);
            boolean increasing = true, decreasing = true;
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) < s.charAt(i-1)) increasing = false;
                if (s.charAt(i) > s.charAt(i-1)) decreasing = false;
            }
            if (!increasing && !decreasing) bouncyCount++;
        }
        result = bouncyCount;

        responseDto.setAnswer(result);
        return responseDto;
    }
}

