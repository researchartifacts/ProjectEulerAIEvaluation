package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ452 {

    public ResponseDto Question452() {
        ResponseDto responseDto = new ResponseDto();
        long MOD = 1234567891L;
        long result = 0;
        long limit = 1000;

        for (long x = 1; x <= limit; x++) {
            for (long y = x + 1; y <= limit; y++) {
                if (x * y <= limit) {
                    result = (result + 1) % MOD;
                }
            }
        }

        responseDto.setAnswer(result);
        return responseDto;
    }
}
