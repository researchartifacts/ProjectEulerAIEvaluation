package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ489 {

    public ResponseDto Question489() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (int a = 1; a <= 100; a++) {
            for (int b = 1; b <= 100; b++) {
                for (int n = 1; n <= 100; n++) {
                    long gcd1 = gcd(n * n * n + b, a);
                    result += gcd1;
                }
            }
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
