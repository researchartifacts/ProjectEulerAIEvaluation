package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ488 {

    public ResponseDto Question488() {
        ResponseDto responseDto = new ResponseDto();
        long MOD = 1000000000L;
        long result = 0;

        for (int heap1 = 1; heap1 <= 100; heap1++) {
            for (int heap2 = heap1 + 1; heap2 <= 100; heap2++) {
                for (int heap3 = heap2 + 1; heap3 <= 100; heap3++) {
                    int xorSum = heap1 ^ heap2 ^ heap3;
                    if (xorSum == 0) {
                        result = (result + (heap1 + heap2 + heap3)) % MOD;
                    }
                }
            }
        }

        responseDto.setAnswer(result);
        return responseDto;
    }
}
