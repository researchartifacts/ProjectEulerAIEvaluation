package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ498 {

    public ResponseDto Question498() {
        ResponseDto responseDto = new ResponseDto();
        long MOD = 999999937L;
        long result = 0;

        long coeff = 1;
        for (int i = 1; i <= 100; i++) {
            coeff = (coeff * i) % MOD;
            result = (result + coeff) % MOD;
        }

        responseDto.setAnswer(result);
        return responseDto;
    }
}
