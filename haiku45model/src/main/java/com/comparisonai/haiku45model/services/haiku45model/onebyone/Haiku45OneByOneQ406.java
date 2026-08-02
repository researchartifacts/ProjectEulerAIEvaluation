package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ406 {

    public ResponseDto Question406() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (int k = 1; k <= 30; k++) {
            long sqrtK = (long) Math.sqrt(k);
            long fibK = fibonacci(k);
            long sqrtFib = (long) Math.sqrt(fibK);

            result += sqrtK + sqrtFib;
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    private long fibonacci(int n) {
        if (n <= 1) return n;
        long a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            long temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }
}
