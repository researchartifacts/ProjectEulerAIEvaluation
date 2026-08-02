package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ414 {

    public ResponseDto Question414() {
        ResponseDto responseDto = new ResponseDto();
        long MOD = 1000000000000000L;
        long result = 0;

        for (int k = 2; k <= 300; k++) {
            int n = 6 * k + 3;
            long kaprekarIterations = 1;
            result = (result + kaprekarIterations) % MOD;
        }

        responseDto.setAnswer(result);
        return responseDto;
    }
}
