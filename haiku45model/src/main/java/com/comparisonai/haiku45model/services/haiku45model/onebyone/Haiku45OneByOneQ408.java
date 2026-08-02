package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ408 {

    public ResponseDto Question408() {
        ResponseDto responseDto = new ResponseDto();
        long MOD = 1000000007L;
        long result = 0;
        int limit = 100;

        for (int x = 0; x <= limit; x++) {
            for (int y = 0; y <= limit; y++) {
                boolean isPerfectSquareX = isPerfectSquare(x);
                boolean isPerfectSquareY = isPerfectSquare(y);
                boolean isPerfectSumXY = isPerfectSquare(x + y);

                if (!isPerfectSquareX || !isPerfectSquareY || !isPerfectSumXY) {
                    result++;
                }
            }
        }

        responseDto.setAnswer(result % MOD);
        return responseDto;
    }

    private boolean isPerfectSquare(long n) {
        if (n < 0) return false;
        long sqrt = (long) Math.sqrt(n);
        return sqrt * sqrt == n;
    }
}
