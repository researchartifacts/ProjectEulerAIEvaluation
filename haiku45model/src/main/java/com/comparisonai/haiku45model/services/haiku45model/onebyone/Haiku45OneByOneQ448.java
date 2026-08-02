package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ448 {

    public ResponseDto Question448() {
        ResponseDto responseDto = new ResponseDto();
        long MOD = 999999017L;
        long result = 0;

        for (int i = 1; i <= 100; i++) {
            for (int j = i + 1; j <= 100; j++) {
                long lcm = calculateLCM(i, j);
                long avg = lcm / 2;
                result = (result + avg) % MOD;
            }
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    private long calculateLCM(long a, long b) {
        return a / gcd(a, b) * b;
    }

    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
