package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ441 {

    public ResponseDto Question441() {
        ResponseDto responseDto = new ResponseDto();
        double result = 0.0;
        int limit = 10000;

        for (int a = 1; a <= limit; a++) {
            for (int b = a + 1; b <= limit; b++) {
                if (gcd(a, b) == 1) {
                    result += (double) a / b;
                }
            }
        }

        responseDto.setAnswer((long) (result * 10000));
        return responseDto;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
