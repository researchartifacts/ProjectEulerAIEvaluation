package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ422 {

    public ResponseDto Question422() {
        ResponseDto responseDto = new ResponseDto();
        long MOD = 1000000007L;

        long a = 1, b = 1, c = 1, d = 1;
        for (int i = 0; i < 100; i++) {
            long nextA = (b + c + d) % MOD;
            b = (a + c + d) % MOD;
            c = (a + b + d) % MOD;
            d = (a + b + c) % MOD;
            a = nextA;
        }

        long result = (a + b + c + d) % MOD;
        responseDto.setAnswer(result);
        return responseDto;
    }
}
