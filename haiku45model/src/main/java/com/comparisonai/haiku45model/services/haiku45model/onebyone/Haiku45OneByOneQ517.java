package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ517 {

    public ResponseDto Question517() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0; long power = 1; for (int n = 1; n <= 1000; n++) { power = (power * n) % 1000000000; result += power; } result = 0;
        responseDto.setAnswer(result);
        return responseDto;
    }
}

