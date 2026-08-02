package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ839 {

    public ResponseDto Question839() {
        ResponseDto responseDto = new ResponseDto();

        long result = 0;
        for (long i = 1; i <= 10000; i++) {
            result += countDivisors(i * i);
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    private long countDivisors(long n) {
        long count = 0;
        for (long i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                count += (i * i == n) ? 1 : 2;
            }
        }
        return count;
    }
}
