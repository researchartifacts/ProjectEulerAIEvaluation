package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ610 {

    public ResponseDto Question610() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;
        double expectedValue = 0;
        int iterations = 1000;
        for (int iter = 0; iter < iterations; iter++) {
            double current = 0;
            while (Math.random() > 0.02) {
                double r = Math.random() * 7;
                if (r < 1) current += 1;
                else if (r < 2) current += 5;
                else if (r < 3) current += 10;
                else if (r < 4) current += 50;
                else if (r < 5) current += 100;
                else if (r < 6) current += 500;
                else current += 1000;
            }
            expectedValue += current;
        }
        result = Math.round(expectedValue / iterations);
        responseDto.setAnswer(result);
        return responseDto;
    }
}
