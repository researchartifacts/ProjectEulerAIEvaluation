package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ515 {

    public ResponseDto Question515() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0; for (int y = 1; y <= 10000; y++) { for (int x = 1; x <= y; x++) { long value = x * x + y * y; long sqrtValue = (long)Math.sqrt(value); if (sqrtValue * sqrtValue == value) { result++; } } }
        responseDto.setAnswer(result);
        return responseDto;
    }
}

