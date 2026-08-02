package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ896 {

    public ResponseDto Question896() {
        ResponseDto responseDto = new ResponseDto();

        long result = 0;
        for (int i = 1; i <= 100; i++) {
            result += (long) i * i * (i + 1) * (i + 1) / 4;
        }

        responseDto.setAnswer(result);
        return responseDto;
    }
}
