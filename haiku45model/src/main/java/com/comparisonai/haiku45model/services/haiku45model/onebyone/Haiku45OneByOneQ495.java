package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ495 {

    public ResponseDto Question495() {
        ResponseDto responseDto = new ResponseDto();
        long MOD = 1000000007L;
        long result = 0;

        for (int a = 1; a <= 100; a++) {
            for (int b = 1; b <= 100; b++) {
                if (a * b <= 100) {
                    result = (result + 1) % MOD;
                }
            }
        }

        responseDto.setAnswer(result);
        return responseDto;
    }
}
