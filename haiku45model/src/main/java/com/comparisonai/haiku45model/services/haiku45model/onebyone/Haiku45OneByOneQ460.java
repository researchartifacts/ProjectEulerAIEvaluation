package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ460 {

    public ResponseDto Question460() {
        ResponseDto responseDto = new ResponseDto();
        double minTime = Double.MAX_VALUE;

        for (double x = 0.0; x <= 10.0; x += 0.01) {
            double time = calculateTime(x);
            minTime = Math.min(minTime, time);
        }

        responseDto.setAnswer((long) (minTime * 1000000000));
        return responseDto;
    }

    private double calculateTime(double x) {
        double velocity = 1.0 + x / 10.0;
        return 10.0 / velocity;
    }
}
