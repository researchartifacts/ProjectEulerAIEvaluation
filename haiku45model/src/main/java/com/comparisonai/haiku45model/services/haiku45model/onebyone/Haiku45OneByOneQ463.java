package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ463 {

    public ResponseDto Question463() {
        ResponseDto responseDto = new ResponseDto();
        long MOD = 1000000000L;
        long result = 0;

        for (long i = 1; i <= 100; i++) {
            long value = calculateCustomFunction(i);
            result = (result + value) % MOD;
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    private long calculateCustomFunction(long n) {
        if (n == 1) return 1;
        if (n % 2 == 0) return calculateCustomFunction(n / 2);
        return calculateCustomFunction(3 * n + 1);
    }
}
