package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ449 {

    public ResponseDto Question449() {
        ResponseDto responseDto = new ResponseDto();
        double a = 3.0, b = 1.0;

        double chocolateAmount = ellipsoidSurfaceArea(a, b);

        responseDto.setAnswer((long) (chocolateAmount * 100000000));
        return responseDto;
    }

    private double ellipsoidSurfaceArea(double a, double b) {
        return 4 * Math.PI * a * b;
    }
}
