package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ446 {

    public ResponseDto Question446() {
        ResponseDto responseDto = new ResponseDto();
        long MOD = 1000000007L;
        long result = 0;

        for (int n = 2; n <= 1000; n++) {
            if (isSophieGermainPrime(n)) {
                long retraction = calculateRetraction(n);
                result = (result + retraction) % MOD;
            }
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    private boolean isSophieGermainPrime(int p) {
        return isPrime(p) && isPrime(2 * p + 1);
    }

    private boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    private long calculateRetraction(int n) {
        return n * (2 * n + 1);
    }
}
