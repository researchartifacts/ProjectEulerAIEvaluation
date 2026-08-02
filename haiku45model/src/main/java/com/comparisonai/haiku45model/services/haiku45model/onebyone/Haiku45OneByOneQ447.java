package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ447 {

    public ResponseDto Question447() {
        ResponseDto responseDto = new ResponseDto();
        long MOD = 1000000007L;
        long result = 0;

        for (long n = 2; n <= 100; n++) {
            long retraction = calculateRetraction(n);
            result = (result + retraction) % MOD;
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    private long calculateRetraction(long n) {
        long odd = 1;
        while (odd <= n) {
            odd *= 2;
        }
        return odd / 2;
    }
}
