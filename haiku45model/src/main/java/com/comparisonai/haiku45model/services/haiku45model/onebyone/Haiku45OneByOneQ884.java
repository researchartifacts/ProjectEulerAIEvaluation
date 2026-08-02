package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ884 {

    public ResponseDto Question884() {
        ResponseDto responseDto = new ResponseDto();

        long result = 0;
        for (int i = 1; i <= 100; i++) {
            result += i * (i + 1) * (2 * i + 1) / 6;
        }

        responseDto.setAnswer(result);
        return responseDto;
    }
}
