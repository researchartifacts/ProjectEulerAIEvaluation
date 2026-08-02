package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ5 {

    public ResponseDto Question5() {
        ResponseDto responseDto = new ResponseDto();
        long result = 1;
        for (int i = 1; i <= 20; i++) {
            result = lcm(result, i);
        }
        responseDto.setAnswer(result);
        return responseDto;
    }

    private long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
