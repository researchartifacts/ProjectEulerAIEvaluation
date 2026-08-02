package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ516 {

    public ResponseDto Question516() {
        ResponseDto responseDto = new ResponseDto();
        long sum = 0; for (int n = 1; n <= 1000; n++) { int count = Integer.bitCount(n); sum += count; } long result = sum;
        responseDto.setAnswer(result);
        return responseDto;
    }
}

