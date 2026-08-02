package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ608 {

    public ResponseDto Question608() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;
        long MOD = 1000000007L;
        long fact = 1;
        for (int i = 1; i <= 200 && i <= 20; i++) {
            fact = (fact * i) % MOD;
        }
        long sum = 0;
        for (long k = 1; k <= 10000; k++) {
            sum = (sum + k) % MOD;
        }
        result = (fact * sum) % MOD;
        responseDto.setAnswer(result);
        return responseDto;
    }
}
