package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ813 {

    public ResponseDto Question813() {
        ResponseDto responseDto = new ResponseDto();

        long MOD = 1000000007L;
        long exponent = calculateExponent();
        long result = xorProductPower(11, exponent, MOD);

        responseDto.setAnswer(result);
        return responseDto;
    }

    private long calculateExponent() {
        long base8 = 1;
        for (int i = 0; i < 12; i++) {
            base8 *= 8;
        }

        long base12 = 1;
        for (int i = 0; i < 8; i++) {
            base12 *= 12;
        }

        return base8 * base12;
    }

    private long xorProductPower(long base, long exponent, long MOD) {
        long result = base;
        for (long i = 1; i < exponent; i++) {
            result = xorProduct(result, base);
        }
        return result % MOD;
    }

    private long xorProduct(long x, long y) {
        long result = 0;
        long shift = 0;
        while (y > 0) {
            if ((y & 1) == 1) {
                result ^= (x << shift);
            }
            y >>= 1;
            shift++;
        }
        return result;
    }
}
