package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ801 {

    public ResponseDto Question801() {
        ResponseDto responseDto = new ResponseDto();

        long result = 0;
        long MOD = 993353399L;
        long start = 10000000000000000L;
        long end = start + 1000000;

        for (long p = start; p <= end; p++) {
            if (isPrime(p)) {
                long fPValue = 0;
                long limit = (long) p * p - p;
                for (long x = 1; x <= limit; x++) {
                    for (long y = 1; y <= limit; y++) {
                        long xPowY = modPow(x, y, p);
                        long yPowX = modPow(y, x, p);
                        if (xPowY == yPowX) {
                            fPValue++;
                        }
                    }
                }
                result = (result + fPValue) % MOD;
            }
        }

        responseDto.setAnswer(result % MOD);
        return responseDto;
    }

    private boolean isPrime(long n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (long i = 3; i * i <= n; i += 2) {
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
