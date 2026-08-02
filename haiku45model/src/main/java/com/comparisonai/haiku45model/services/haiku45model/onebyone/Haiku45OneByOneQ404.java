package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ404 {

    public ResponseDto Question404() {
        ResponseDto responseDto = new ResponseDto();
        long count = 0;
        int maxA = 1000;

        for (int a = 1; a <= maxA; a++) {
            for (int b = 100; b <= 1000; b++) {
                for (int c = 100; c <= 1000; c++) {
                    if (b < c) {
                        double ratio = (double) a / c;
                        if (ratio > 0.5 && ratio < 2.0) {
                            count++;
                        }
                    }
                }
            }
        }

        responseDto.setAnswer(count);
        return responseDto;
    }
}
