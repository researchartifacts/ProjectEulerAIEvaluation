package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ833 {

    public ResponseDto Question833() {
        ResponseDto responseDto = new ResponseDto();

        long result = 0;
        for (int a = 1; a <= 1000; a++) {
            for (int b = a; b <= 1000; b++) {
                for (int c = b; c <= 1000; c++) {
                    if (isValidTriangle(a, b, c)) {
                        result++;
                    }
                }
            }
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    private boolean isValidTriangle(int a, int b, int c) {
        return a + b > c && isAcute(a, b, c);
    }

    private boolean isAcute(int a, int b, int c) {
        return a * a + b * b > c * c;
    }
}
