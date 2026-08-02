package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ824 {

    public ResponseDto Question824() {
        ResponseDto responseDto = new ResponseDto();

        long n = 1000000000L;
        long k = 1000000000000000L;
        long MOD = 10000019L * 10000019L;

        long result = countNonAttackingSliders(n, k, MOD);

        responseDto.setAnswer(result);
        return responseDto;
    }

    private long countNonAttackingSliders(long n, long k, long MOD) {
        long result = 1;
        for (long i = 0; i < Math.min(k, n * n); i++) {
            result = (result * (n - (i % n))) % MOD;
        }
        return result;
    }
}
