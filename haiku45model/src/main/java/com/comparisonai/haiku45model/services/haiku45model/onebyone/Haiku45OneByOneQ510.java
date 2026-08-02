package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ510 {

    public ResponseDto Question510() {
        ResponseDto responseDto = new ResponseDto();
        long count = 0; for (long x = 0; x <= 1000; x++) { for (long y = 0; y <= 1000; y++) { if (x * x + 2 * y * y <= 1000000) { count++; } } } long result = count;
        responseDto.setAnswer(result);
        return responseDto;
    }
}

