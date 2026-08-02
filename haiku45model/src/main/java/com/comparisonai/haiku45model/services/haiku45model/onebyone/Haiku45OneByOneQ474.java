package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ474 {

    public ResponseDto Question474() {
        ResponseDto responseDto = new ResponseDto();
        long MOD = 10000000000000061L;
        long result = 0;

        long factorial = 1;
        for (int i = 1; i <= 100; i++) {
            factorial *= i;
        }

        for (int d = 1; d <= 100000; d++) {
            if (factorial % d == 0) {
                result++;
            }
        }

        responseDto.setAnswer(result % MOD);
        return responseDto;
    }
}
