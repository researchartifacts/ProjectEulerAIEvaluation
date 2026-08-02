package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ497 {

    public ResponseDto Question497() {
        ResponseDto responseDto = new ResponseDto();
        long MOD = 1000000000L;
        long result = 0;

        for (int n = 1; n <= 100; n++) {
            long hanoi = hanoi(n);
            result = (result + hanoi) % MOD;
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    private long hanoi(int n) {
        return (1L << n) - 1;
    }
}
