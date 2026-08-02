package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ602 {

    public ResponseDto Question602() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;
        long MOD = 1000000007L;
        long n = 10000;
        long k = 4000;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= Math.min(k, 1000); j++) {
                result = (result + i * j) % MOD;
            }
        }
        responseDto.setAnswer(result);
        return responseDto;
    }
}
