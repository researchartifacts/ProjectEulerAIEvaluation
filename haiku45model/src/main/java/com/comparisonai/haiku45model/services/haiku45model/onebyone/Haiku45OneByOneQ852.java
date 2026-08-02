package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ852 {

    public ResponseDto Question852() {
        ResponseDto responseDto = new ResponseDto();

        long result = 0;
        for (int i = 1; i <= 100; i++) {
            for (int j = 1; j <= 100; j++) {
                if (canReach(i, j)) {
                    result++;
                }
            }
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    private boolean canReach(int x, int y) {
        while (x > 0 && y > 0) {
            if (x > y) x %= y;
            else if (y > x) y %= x;
            else break;
        }
        return x == 0 || y == 0;
    }
}
