package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ420 {

    public ResponseDto Question420() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;
        int limit = 100;

        for (int a = 1; a <= limit; a++) {
            for (int b = 1; b <= limit; b++) {
                for (int c = 1; c <= limit; c++) {
                    for (int d = 1; d <= limit; d++) {
                        int trace = a + d;
                        if (trace < limit && isMatrixPerfectSquare(a, b, c, d)) {
                            result++;
                        }
                    }
                }
            }
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    private boolean isMatrixPerfectSquare(int a, int b, int c, int d) {
        return (a * a + b * c) == (a + d);
    }
}
