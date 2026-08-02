package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ657 {

    public ResponseDto Question657() {
        ResponseDto responseDto = new ResponseDto();

        long alpha = 10000000;
        long n = 1000000000000L;
        long mod = 1000000007;

        long result = calculateI(alpha, n, mod);

        responseDto.setAnswer(result);
        return responseDto;
    }

    private long calculateI(long alpha, long n, long mod) {
        long sum = 0;
        long[] fact = new long[(int) alpha + 1];
        long[] invFact = new long[(int) alpha + 1];
        fact[0] = 1;
        for (int i = 1; i <= alpha; i++) fact[i] = (fact[i - 1] * i) % mod;
        invFact[(int) alpha] = power(fact[(int) alpha], mod - 2, mod);
        for (int i = (int) alpha - 1; i >= 0; i--) invFact[i] = (invFact[i + 1] * (i + 1)) % mod;

        for (int j = 0; j < alpha; j++) {
            long comb = (((fact[(int) alpha] * invFact[j]) % mod) * invFact[(int) (alpha - j)]) % mod;
            long geom;
            if (j == 0) geom = 1;
            else if (j == 1) geom = (n + 1) % mod;
            else {
                long num = (power(j, n + 1, mod) - 1 + mod) % mod;
                long den = modInverse(j - 1, mod);
                geom = (num * den) % mod;
            }

            long term = (comb * geom) % mod;
            if ((alpha - 1 - j) % 2 == 1) sum = (sum - term + mod) % mod;
            else sum = (sum + term) % mod;
        }
        return sum;
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
