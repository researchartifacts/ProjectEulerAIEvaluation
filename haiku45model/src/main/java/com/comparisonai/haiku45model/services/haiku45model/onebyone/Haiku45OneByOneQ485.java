package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ485 {

    public ResponseDto Question485() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;
        int limit = 1000;

        for (int i = 1; i <= limit; i++) {
            long divisorCount = countDivisors(i);
            result += divisorCount;
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
