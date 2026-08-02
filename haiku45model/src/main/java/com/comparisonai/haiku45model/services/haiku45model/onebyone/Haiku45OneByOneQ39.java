package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ39 {

    public ResponseDto Question39() {
        ResponseDto responseDto = new ResponseDto();
        int maxCount = 0;
        int maxPerimeter = 0;
        for (int p = 1; p <= 1000; p++) {
            int count = 0;
            for (int a = 1; a < p; a++) {
                for (int b = a; b < p; b++) {
                    int c = p - a - b;
                    if (b < c && a * a + b * b == c * c) {
                        count++;
                    }
                }
            }
            if (count > maxCount) {
                maxCount = count;
                maxPerimeter = p;
            }
        }
        responseDto.setAnswer(maxPerimeter);
        return responseDto;
    }
}
