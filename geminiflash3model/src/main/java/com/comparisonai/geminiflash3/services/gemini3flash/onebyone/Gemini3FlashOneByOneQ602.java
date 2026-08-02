package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ602 {

    private static final long MOD = 1_000_000_007;

    public ResponseDto Question602() {
        ResponseDto responseDto = new ResponseDto();
        
        int n = 10_000_000;
        int k = 4_000_000;
        
        responseDto.setAnswer(eulerianNumber(n, k));
        return responseDto;
    }

    private long eulerianNumber(int n, int k) {
        long res = 0;
        long[] fact = new long[k + 1];
        long[] invFact = new long[k + 1];
        fact[0] = 1;
        invFact[0] = 1;
        for (int i = 1; i <= k; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }
        invFact[k] = power(fact[k], MOD - 2);
        for (int i = k - 1; i >= 1; i--) {
            invFact[i] = (invFact[i + 1] * (i + 1)) % MOD;
        }

        for (int j = 0; j <= k; j++) {
            long term = nCr(n + 1, j, fact, invFact);
            term = (term * power(k - j, n)) % MOD;
            if (j % 2 == 1) {
                res = (res - term + MOD) % MOD;
            } else {
                res = (res + term) % MOD;
            }
        }
        return res;
    }

    private long nCr(int n, int r, long[] fact, long[] invFact) {
        if (r < 0 || r > n) return 0;
        long num = 1;
        for (int i = 0; i < r; i++) {
            num = (num * (n - i)) % MOD;
        }
        return (num * invFact[r]) % MOD;
    }

    private long power(long base, long exp) {
        long res = 1;
        base %= MOD;
        while (exp > 0) {
            if (exp % 2 == 1) res = (res * base) % MOD;
            base = (base * base) % MOD;
            exp /= 2;
        }
        return res;
    }
}
