package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ493 {

    public ResponseDto Question493() {
        ResponseDto responseDto = new ResponseDto();
        int ballsPerColor = 10;
        int colors = 7;
        int drawn = 20;

        double expected = colors * (1.0 - Math.pow(1.0 - ballsPerColor / (ballsPerColor * colors), drawn));
        responseDto.setAnswer((long) (expected * 1000000000));
        return responseDto;
    }
}
