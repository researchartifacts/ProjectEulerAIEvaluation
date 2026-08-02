package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ432 {

    public ResponseDto Question432() {
        ResponseDto responseDto = new ResponseDto();
        long MOD = 1000000000L;
        long result = 0;
        int n = 510510;
        int limit = 10000;

        for (int i = 1; i <= limit; i++) {
            long phi = calculateEulerPhi(n * i);
            result = (result + phi) % MOD;
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    private long calculateEulerPhi(long n) {
        long result = n;
        for (long p = 2; p * p <= n; p++) {
            if (n % p == 0) {
                while (n % p == 0) n /= p;
                result -= result / p;
            }
        }
        if (n > 1) result -= result / n;
        return result;
    }
}
