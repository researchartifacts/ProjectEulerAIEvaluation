package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ499 {

    public ResponseDto Question499() {
        ResponseDto responseDto = new ResponseDto();
        double probability = 0.5;

        for (int round = 1; round <= 15; round++) {
            probability *= 0.99;
        }

        responseDto.setAnswer((long) (probability * 10000000));
        return responseDto;
    }
}
