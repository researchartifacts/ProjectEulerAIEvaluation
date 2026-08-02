package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ606 {

    public ResponseDto Question606() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;
        long MOD = 1000000007L;
        long limit = 1000000;
        long count = 0;
        for (long n = 2; n <= Math.min(limit, 10000); n++) {
            long divisors = 0;
            for (long d = 1; d * d <= n; d++) {
                if (n % d == 0) {
                    divisors++;
                    if (d != n / d) divisors++;
                }
            }
            if (divisors > 0) count += divisors;
        }
        result = count % MOD;
        responseDto.setAnswer(result);
        return responseDto;
    }
}
