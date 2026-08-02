package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ429 {

    public ResponseDto Question429() {
        ResponseDto responseDto = new ResponseDto();
        long MOD = 1000000009L;
        long result = 0;

        for (int n = 1; n <= 1000; n++) {
            long unitaryDivisorSum = 0;
            for (int i = 1; i <= n; i++) {
                if (gcd(i, n) == 1 && n % i == 0) {
                    unitaryDivisorSum += i * i;
                }
            }
            result = (result + unitaryDivisorSum) % MOD;
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
