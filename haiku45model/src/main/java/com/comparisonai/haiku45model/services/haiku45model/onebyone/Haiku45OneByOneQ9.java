package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ9 {

    public ResponseDto Question9() {
        ResponseDto responseDto = new ResponseDto();
        for (int a = 1; a < 1000; a++) {
            for (int b = a + 1; b < 1000; b++) {
                int c = 1000 - a - b;
                if (b < c && a * a + b * b == c * c) {
                    responseDto.setAnswer((long) a * b * c);
                    return responseDto;
                }
            }
        }
        return responseDto;
    }
}
