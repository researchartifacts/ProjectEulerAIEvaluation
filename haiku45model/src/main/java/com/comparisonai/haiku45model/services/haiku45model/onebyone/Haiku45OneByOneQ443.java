package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ443 {

    public ResponseDto Question443() {
        ResponseDto responseDto = new ResponseDto();
        long g = 13;

        for (long n = 1; n <= 100; n++) {
            g = g + gcd(n, g);
        }

        responseDto.setAnswer(g);
        return responseDto;
    }

    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
