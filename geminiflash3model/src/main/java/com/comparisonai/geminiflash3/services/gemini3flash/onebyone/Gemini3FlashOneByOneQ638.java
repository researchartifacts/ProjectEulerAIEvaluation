package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ638 {

    public ResponseDto Question638() {
        ResponseDto responseDto = new ResponseDto();
        long mod = 1000000007L;
        long totalSum = 0;

        for (int k = 1; k <= 7; k++) {
            long n = (long) Math.pow(10, k) + k;
            totalSum = (totalSum + qBinomial(2 * n, n, k, mod)) % mod;
        }

        responseDto.setAnswer(totalSum);
        return responseDto;
    }

    private long qBinomial(long n, long k, int qVal, long mod) {
        if (qVal == 1) return combinations(n, k, mod);
        
        // C(n, k, q) = prod_{i=1 to k} (1 - q^(n-i+1)) / (1 - q^i)
        long q = qVal;
        long num = 1;
        long den = 1;
        for (int i = 1; i <= k; i++) {
            num = num * (1 - power(q, n - i + 1, mod) + mod) % mod;
            den = den * (1 - power(q, i, mod) + mod) % mod;
        }
        return num * power(den, mod - 2, mod) % mod;
    }

    private long combinations(long n, long k, long mod) {
        if (k < 0 || k > n) return 0;
        if (k == 0 || k == n) return 1;
        if (k > n / 2) k = n - k;
        long num = 1;
        long den = 1;
        for (int i = 0; i < k; i++) {
            num = num * ((n - i) % mod) % mod;
            den = den * (i + 1) % mod;
        }
        return num * power(den, mod - 2, mod) % mod;
    }

    private long power(long a, long b, long m) {
        long res = 1;
        a %= m;
        while (b > 0) {
            if (b % 2 == 1) res = (res * a) % m;
            a = (a * a) % m;
            b /= 2;
        }
        return res;
    }
}
