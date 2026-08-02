package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ551 {

    public ResponseDto Question551() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0; for (int i = 1; i <= 10000; i++) { int f = i; while (f > 0) { result += f % 10; f /= 10; } }
        responseDto.setAnswer(result);
        return responseDto;
    }
}

