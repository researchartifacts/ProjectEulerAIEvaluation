package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ870 {

    public ResponseDto Question870() {
        ResponseDto responseDto = new ResponseDto();

        long MOD = 1000000007L;
        long result = 0;
        for (int i = 1; i <= 1000; i++) {
            result = (result + modPow(2, i, MOD)) % MOD;
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    private long modPow(long base, long exp, long mod) {
        long result = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1) result = (result * base) % mod;
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }
}
