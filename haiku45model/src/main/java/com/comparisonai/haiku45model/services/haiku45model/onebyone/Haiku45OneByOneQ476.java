package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ476 {

    public ResponseDto Question476() {
        ResponseDto responseDto = new ResponseDto();
        double result = 0.0;

        for (int i = 1; i <= 100; i++) {
            double radius = 1.0 / i;
            double area = Math.PI * radius * radius;
            result += area;
        }

        responseDto.setAnswer((long) (result * 100000));
        return responseDto;
    }
}
