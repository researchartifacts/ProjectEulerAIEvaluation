package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ500 {

    public ResponseDto Question500() {
        ResponseDto responseDto = new ResponseDto();
        long MOD = 500500507L;
        long result = 2;

        for (long i = 2; i <= 1000000; i++) {
            long divisorCount = countDivisors(i);
            if (divisorCount > 500500) {
                result = i % MOD;
                break;
            }
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    private long countDivisors(long n) {
        long count = 0;
        for (long i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                count += (i == n / i) ? 1 : 2;
            }
        }
        return count;
    }
}
