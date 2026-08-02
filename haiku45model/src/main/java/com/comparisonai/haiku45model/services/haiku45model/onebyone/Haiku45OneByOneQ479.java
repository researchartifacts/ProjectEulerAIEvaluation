package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ479 {

    public ResponseDto Question479() {
        ResponseDto responseDto = new ResponseDto();
        long MOD = 1000000007L;
        long result = 0;

        for (int n = 1; n <= 100; n++) {
            long rootSum = 0;
            for (int i = 1; i <= n; i++) {
                rootSum += i;
            }
            result = (result + rootSum * rootSum) % MOD;
        }

        responseDto.setAnswer(result);
        return responseDto;
    }
}
