package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ438 {

    public ResponseDto Question438() {
        ResponseDto responseDto = new ResponseDto();
        double result = 0.0;

        for (int t = 0; t <= 100; t++) {
            double rootSum = 0.0;
            for (int i = 0; i <= 10; i++) {
                if (Math.floor(Math.pow(t, 1.0 / (i + 1))) == i) {
                    rootSum += i;
                }
            }
            result += rootSum;
        }

        responseDto.setAnswer((long) (result * 1000));
        return responseDto;
    }
}
