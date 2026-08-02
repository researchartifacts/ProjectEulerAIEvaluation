package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ484 {

    public ResponseDto Question484() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (long k = 2; k <= 100; k++) {
            long kPrime = arithmeticDerivative(k);
            result += gcd(k, kPrime);
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    private long arithmeticDerivative(long n) {
        if (n <= 1) return 0;
        long derivative = 0;
        for (long i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                derivative += n / i;
            }
        }
        return derivative;
    }

    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
