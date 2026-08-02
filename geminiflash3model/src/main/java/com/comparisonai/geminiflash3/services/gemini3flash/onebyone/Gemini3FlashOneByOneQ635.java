package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;

@Service
public class Gemini3FlashOneByOneQ635 {

    public ResponseDto Question635() {
        ResponseDto responseDto = new ResponseDto();
        int limit = 100000000;
        long mod = 1000000009L;

        long sumS2 = solve(2, limit, mod);
        long sumS3 = solve(3, limit, mod);

        responseDto.setAnswer((sumS2 + sumS3) % mod);
        return responseDto;
    }

    private long solve(int q, int limit, long mod) {
        long total = 0;
        boolean[] isPrime = new boolean[limit + 1];
        for (int i = 2; i <= limit; i++) isPrime[i] = true;
        
        for (int p = 2; p <= limit; p++) {
            if (isPrime[p]) {
                total = (total + aqp(q, p, mod)) % mod;
                if ((long)p * p <= limit) {
                    for (int j = p * p; j <= limit; j += p) isPrime[j] = false;
                }
            }
        }
        return total;
    }

    private long aqp(int q, int p, long mod) {
        if (p == 2) {
            // A_q(2) = (binom(2q, 2) - q) / 2 for q=2,3
            long b = combinations(2 * q, 2, mod);
            return (b - q + mod) * power(2, mod - 2, mod) % mod;
        }
        // A_q(p) = (binom(qp, p) + q(p-1)) / p
        BigInteger b = combinationsBig(q * p, p);
        BigInteger res = b.add(BigInteger.valueOf(q).multiply(BigInteger.valueOf(p - 1)));
        return res.divide(BigInteger.valueOf(p)).remainder(BigInteger.valueOf(mod)).longValue();
    }

    private long combinations(int n, int k, long mod) {
        if (k < 0 || k > n) return 0;
        long res = 1;
        for (int i = 0; i < k; i++) {
            res = (res * (n - i)) % mod;
            res = (res * power(i + 1, mod - 2, mod)) % mod;
        }
        return res;
    }

    private BigInteger combinationsBig(int n, int k) {
        if (k < 0 || k > n) return BigInteger.ZERO;
        if (k > n / 2) k = n - k;
        BigInteger res = BigInteger.ONE;
        for (int i = 1; i <= k; i++) {
            res = res.multiply(BigInteger.valueOf(n - i + 1)).divide(BigInteger.valueOf(i));
        }
        return res;
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
