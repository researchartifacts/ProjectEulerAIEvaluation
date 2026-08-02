package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ871 {

    public ResponseDto Question871() {
        ResponseDto responseDto = new ResponseDto();

        long result = 0;
        for (int i = 1; i <= 100; i++) {
            result += triangularNumber(i);
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    private long triangularNumber(int n) {
        return (long) n * (n + 1) / 2;
    }
}
