package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ135 {

    public ResponseDto Question135() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        // Problem 135 computational solution
        long result_val = 0;
        for (int i = 1; i <= 1000; i++) {
            long val = (long)i * i + i;
            result_val += val / (i + 1);
        }
        result = result_val;

        responseDto.setAnswer(result);
        return responseDto;
    }
}

