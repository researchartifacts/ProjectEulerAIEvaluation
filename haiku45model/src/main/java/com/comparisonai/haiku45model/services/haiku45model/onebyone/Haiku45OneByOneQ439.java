package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ439 {

    public ResponseDto Question439() {
        ResponseDto responseDto = new ResponseDto();
        long MOD = 1000000000L;
        long result = 0;
        int limit = 1000;

        for (int i = 1; i <= limit; i++) {
            for (int j = 1; j <= limit; j++) {
                long divisorSum = countDivisors(i * j);
                result = (result + divisorSum) % MOD;
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
