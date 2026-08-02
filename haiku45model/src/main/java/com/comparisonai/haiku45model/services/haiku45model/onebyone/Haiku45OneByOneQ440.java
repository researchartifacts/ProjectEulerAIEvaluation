package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ440 {

    public ResponseDto Question440() {
        ResponseDto responseDto = new ResponseDto();
        long MOD = 987898789L;
        long result = 0;

        for (int i = 1; i <= 100; i++) {
            for (int j = 1; j <= 100; j++) {
                for (int k = 1; k <= 100; k++) {
                    long gcd = gcd(gcd(i, j), k);
                    result = (result + gcd) % MOD;
                }
            }
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
