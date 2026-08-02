package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;

@Service
public class Gemini3FlashOneByOneQ801 {

    public ResponseDto Question801() {
        ResponseDto responseDto = new ResponseDto();
        long M = 10000000000000000L;
        long N = M + 1000000L;
        long MOD = 993353399;
        long totalSum = 0;

        for (long p = nextPrime(M); p <= N; p = nextPrime(p + 1)) {
            totalSum = (totalSum + f(p, MOD)) % MOD;
        }

        responseDto.setAnswer(totalSum);
        return responseDto;
    }

    private long f(long p, long mod) {
        long pMinus1 = p - 1;
        long term1 = BigInteger.valueOf(pMinus1).multiply(BigInteger.valueOf(pMinus1)).mod(BigInteger.valueOf(mod)).longValue();
        long term2 = 0;
        for (long i = 1; i < p; i++) {
            long d = gcd(i, pMinus1);
            term2 = (term2 + BigInteger.valueOf(pMinus1).multiply(BigInteger.valueOf(d)).mod(BigInteger.valueOf(mod)).longValue()) % mod;
        }
        return (term1 + term2) % mod;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            a %= b;
            long temp = a;
            a = b;
            b = temp;
        }
        return a;
    }

    private long nextPrime(long n) {
        if (n <= 2) return 2;
        if (n % 2 == 0) n++;
        while (!isPrime(n)) {
            n += 2;
        }
        return n;
    }

    private boolean isPrime(long n) {
        if (n < 2) return false;
        if (n == 2 || n == 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        for (long i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }
}
