package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ428 {

    public ResponseDto Question428() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;
        int limit = 100;

        for (int a = 1; a <= limit; a++) {
            for (int b = a + 1; b <= limit; b++) {
                for (int c = b + 1; c <= limit; c++) {
                    if (isValidTriplet(a, b, c)) {
                        result++;
                    }
                }
            }
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    private boolean isValidTriplet(int a, int b, int c) {
        return (a + b > c) && (b + c > a) && (a + c > b);
    }
}
