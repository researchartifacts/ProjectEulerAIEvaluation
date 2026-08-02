package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ471 {

    public ResponseDto Question471() {
        ResponseDto responseDto = new ResponseDto();
        double sumRadii = 0.0;

        for (int i = 0; i < 100; i++) {
            double incircleRadius = calculateIncircleRadius(i);
            sumRadii += incircleRadius;
        }

        responseDto.setAnswer((long) (sumRadii * 1000000000000L));
        return responseDto;
    }

    private double calculateIncircleRadius(int i) {
        return 1.0 / (2.0 + i);
    }
}
