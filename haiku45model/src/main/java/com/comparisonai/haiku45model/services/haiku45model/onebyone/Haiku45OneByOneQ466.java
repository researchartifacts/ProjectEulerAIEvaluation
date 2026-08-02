package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ466 {

    public ResponseDto Question466() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;
        int limit = 64;

        for (int i = 1; i <= limit; i++) {
            for (long j = 1; j <= 1000; j++) {
                result += i * j;
            }
        }

        responseDto.setAnswer(result);
        return responseDto;
    }
}
