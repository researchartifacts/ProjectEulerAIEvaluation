package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ402 {

    public ResponseDto Question402() {
        ResponseDto responseDto = new ResponseDto();
        long MOD = 1000000000L;
        long result = 0;

        int[] fib = new int[100];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i < 100; i++) {
            fib[i] = fib[i-1] + fib[i-2];
        }

        for (int k = 2; k <= Math.min(100, 1234567890); k++) {
            long F_k = fib[k % 100];
            result = (result + (F_k % MOD)) % MOD;
        }

        responseDto.setAnswer(result);
        return responseDto;
    }
}
