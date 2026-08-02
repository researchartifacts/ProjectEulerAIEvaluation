package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ465 {

    public ResponseDto Question465() {
        ResponseDto responseDto = new ResponseDto();
        long MOD = 1000000007L;
        long result = 0;
        int limit = 100;

        for (int x = 0; x <= limit; x++) {
            for (int y = 0; y <= limit; y++) {
                if (isLatticePoint(x, y)) {
                    result = (result + 1) % MOD;
                }
            }
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    private boolean isLatticePoint(int x, int y) {
        return (x * x + y * y) % 2 == 0;
    }
}
