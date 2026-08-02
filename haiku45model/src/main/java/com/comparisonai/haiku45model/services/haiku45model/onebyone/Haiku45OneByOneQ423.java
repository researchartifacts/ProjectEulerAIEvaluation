package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ423 {

    public ResponseDto Question423() {
        ResponseDto responseDto = new ResponseDto();
        long MOD = 1000000007L;
        long result = 0;

        for (int roll1 = 1; roll1 <= 6; roll1++) {
            for (int roll2 = 1; roll2 <= 6; roll2++) {
                if (roll1 == roll2) {
                    result = (result + 1) % MOD;
                }
            }
        }

        responseDto.setAnswer(result);
        return responseDto;
    }
}
