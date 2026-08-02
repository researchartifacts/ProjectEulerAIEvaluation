package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ834 {

    public ResponseDto Question834() {
        ResponseDto responseDto = new ResponseDto();

        long result = 0;
        int n = 100;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                long val = (long) i * i + j * j;
                if (isPerfectSquare(val)) {
                    result++;
                }
            }
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    private boolean isPerfectSquare(long n) {
        long sqrt = (long) Math.sqrt(n);
        return sqrt * sqrt == n;
    }
}
