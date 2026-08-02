package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ487 {

    public ResponseDto Question487() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;
        long base = 2000000000L;

        for (long p = base; p <= base + 2000; p++) {
            if (isPrime(p)) {
                long s = 0;
                for (long i = 1; i <= 10000; i++) {
                    s = (s + modPow(i, 10000, p)) % p;
                }
                result += s;
            }
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    private boolean isPrime(long n) {
        if (n < 2) return false;
        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    private long modPow(long base, long exp, long mod) {
        long result = 1;
        base %= mod;
        while (exp > 0) {
            if (exp % 2 == 1) result = (result * base) % mod;
            base = (base * base) % mod;
            exp /= 2;
        }
        return result;
    }
}
