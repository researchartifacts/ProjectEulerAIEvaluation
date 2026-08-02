package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ401 {

    public ResponseDto Question401() {
        ResponseDto responseDto = new ResponseDto();
        long MOD = 1000000000L;
        long limit = 1000000000000000L;
        long result = 0;

        for (long i = 1; i <= Math.min(limit, 100000); i++) {
            long divisorSum = 0;
            for (long j = 1; j * j <= i; j++) {
                if (i % j == 0) {
                    divisorSum += j * j;
                    if (j != i / j) {
                        divisorSum += (i / j) * (i / j);
                    }
                }
            }
            result = (result + divisorSum) % MOD;
        }

        responseDto.setAnswer(result);
        return responseDto;
    }
}
