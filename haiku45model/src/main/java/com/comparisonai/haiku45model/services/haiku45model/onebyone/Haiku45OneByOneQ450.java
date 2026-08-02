package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ450 {

    public ResponseDto Question450() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (double angle = 0; angle < 360; angle += 1) {
            double x = Math.cos(Math.toRadians(angle));
            double y = Math.sin(Math.toRadians(angle));
            result += (long) Math.abs(x) + (long) Math.abs(y);
        }

        responseDto.setAnswer(result);
        return responseDto;
    }
}
