package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ461 {

    public ResponseDto Question461() {
        ResponseDto responseDto = new ResponseDto();
        double result = 0.0;

        for (double a = 0.1; a <= 100; a += 1.0) {
            for (double b = 0.1; b <= 100; b += 1.0) {
                double piApprox = a * Math.exp(-b);
                double error = Math.abs(piApprox - Math.PI);
                result += a * a + b * b;
            }
        }

        responseDto.setAnswer((long) result);
        return responseDto;
    }
}
