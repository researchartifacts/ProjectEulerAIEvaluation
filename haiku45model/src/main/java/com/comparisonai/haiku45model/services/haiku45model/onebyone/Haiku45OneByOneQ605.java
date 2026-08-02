package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ605 {

    public ResponseDto Question605() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;
        long total = 0;
        double probability = 0.5;
        for (int i = 1; i <= 1000; i++) {
            probability *= 0.5;
            total += (long)(probability * 1000000);
        }
        result = total;
        responseDto.setAnswer(result);
        return responseDto;
    }
}
