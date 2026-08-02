package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ475 {

    public ResponseDto Question475() {
        ResponseDto responseDto = new ResponseDto();
        long MOD = 1000000007L;
        long result = 0;

        for (int musician = 0; musician < 100; musician++) {
            long ways = factorial(3) * factorial(2);
            result = (result + ways) % MOD;
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    private long factorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
