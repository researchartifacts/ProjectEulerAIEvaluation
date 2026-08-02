package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ478 {

    public ResponseDto Question478() {
        ResponseDto responseDto = new ResponseDto();
        long MOD = 214358881L;
        long result = 0;

        for (int i = 1; i <= 100; i++) {
            for (int j = 1; j <= 100; j++) {
                if ((i + j) % 2 == 0) {
                    result = (result + 1) % MOD;
                }
            }
        }

        responseDto.setAnswer(result);
        return responseDto;
    }
}
