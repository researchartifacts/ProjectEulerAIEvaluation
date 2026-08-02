package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ416 {

    public ResponseDto Question416() {
        ResponseDto responseDto = new ResponseDto();
        long MOD = 1000000000L;
        long result = 0;
        int numSquares = 10;

        for (int square = 0; square < numSquares; square++) {
            for (int jumpSize = 1; jumpSize <= 5; jumpSize++) {
                if ((square + jumpSize) < numSquares) {
                    result++;
                }
            }
        }

        responseDto.setAnswer(result % MOD);
        return responseDto;
    }
}
