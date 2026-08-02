package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ492 {

    public ResponseDto Question492() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (int i = 1; i <= 100; i++) {
            result += i % 7;
        }

        responseDto.setAnswer(result);
        return responseDto;
    }
}
