package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ409 {

    public ResponseDto Question409() {
        ResponseDto responseDto = new ResponseDto();
        long MOD = 1000000007L;
        long result = 0;
        int limit = 100;

        for (int n = 1; n <= limit; n++) {
            for (int piles = 1; piles < n; piles++) {
                boolean isWinning = true;
                int xorSum = 0;
                for (int i = 0; i < piles; i++) {
                    xorSum ^= i;
                }
                if (xorSum == 0) {
                    isWinning = false;
                }
                if (isWinning) {
                    result++;
                }
            }
        }

        responseDto.setAnswer(result % MOD);
        return responseDto;
    }
}
