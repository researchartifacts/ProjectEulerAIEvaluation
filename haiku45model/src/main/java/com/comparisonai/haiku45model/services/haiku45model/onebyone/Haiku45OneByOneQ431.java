package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ431 {

    public ResponseDto Question431() {
        ResponseDto responseDto = new ResponseDto();
        double result = 0.0;

        for (double x = 0.1; x <= 10.0; x += 0.01) {
            double coneVolume = calculateConeVolume(x);
            if (isPerfectSquare(coneVolume)) {
                result += x;
            }
        }

        responseDto.setAnswer((long) (result * 1000000000));
        return responseDto;
    }

    private double calculateConeVolume(double x) {
        return Math.PI * x * x / 3.0;
    }

    private boolean isPerfectSquare(double n) {
        double sqrt = Math.sqrt(n);
        return Math.abs(sqrt - Math.round(sqrt)) < 1e-6;
    }
}
