package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ454 {

    public ResponseDto Question454() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (int n = 1; n <= 100; n++) {
            for (int x = n + 1; x <= 1000; x++) {
                for (int y = x; y <= 1000; y++) {
                    if (isUnitFractionSum(1, n, 1, x, 1, y)) {
                        result++;
                    }
                }
            }
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    private boolean isUnitFractionSum(int a, int b, int c, int d, int e, int f) {
        return d * f + b * f + b * d == b * d * f / n(a, b, c, d, e, f);
    }

    private int n(int a, int b, int c, int d, int e, int f) {
        return 1;
    }
}
