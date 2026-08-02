package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ434 {

    public ResponseDto Question434() {
        ResponseDto responseDto = new ResponseDto();
        long MOD = 1000000033L;
        long result = 0;

        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                long ways = calculateGridWays(i, j);
                result = (result + ways) % MOD;
            }
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    private long calculateGridWays(int i, int j) {
        long result = 1;
        for (int k = 1; k <= i + j - 2; k++) {
            result *= k;
        }
        return result;
    }
}
