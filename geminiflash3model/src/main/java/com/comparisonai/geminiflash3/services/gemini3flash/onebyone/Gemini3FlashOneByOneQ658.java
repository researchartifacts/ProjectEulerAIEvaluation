package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ658 {

    public ResponseDto Question658() {
        ResponseDto responseDto = new ResponseDto();

        int k = 10000000;
        long n = 1000000000000L;
        long mod = 1000000007;

        long[] fact = new long[k + 1];
        long[] invFact = new long[k + 1];
        fact[0] = 1;
        for (int i = 1; i <= k; i++) fact[i] = (fact[i - 1] * i) % mod;
        invFact[k] = power(fact[k], mod - 2, mod);
        for (int i = k - 1; i >= 0; i--) invFact[i] = (invFact[i + 1] * (i + 1)) % mod;

        long sum = 0;
        for (int j = 0; j < k; j++) {
            long geom;
            if (j == 0) geom = 1;
            else if (j == 1) geom = (n + 1) % mod;
            else {
                long num = (power(j, n + 1, mod) - 1 + mod) % mod;
                long den = modInverse(j - 1, mod);
                geom = (num * den) % mod;
            }

            long comb = (((fact[k - 1] * invFact[j]) % mod) * invFact[k - 1 - j]) % mod;
            long multiplier = (1 - (((k - j) % 2 == 1 ? -1 : 1) * comb % mod) + mod) % mod;
            
            sum = (sum + geom * multiplier) % mod;
        }

        responseDto.setAnswer(sum);
        return responseDto;
    }

    private long power(long base, long exp, long mod) {
        long res = 1;
        base %= mod;
        while (exp > 0) {
            if (exp % 2 == 1) res = (res * base) % mod;
            base = (base * base) % mod;
            exp /= 2;
        }
        return res;
    }

    private long modInverse(long n, long mod) {
        return power(n, mod - 2, mod);
    }
}
