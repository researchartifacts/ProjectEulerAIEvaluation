package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class Gemini3FlashOneByOneQ659 {

    public ResponseDto Question659() {
        ResponseDto responseDto = new ResponseDto();

        int limit = 10000000;
        long[] a = new long[limit + 1];
        long[] pMax = new long[limit + 1];

        for (int k = 1; k <= limit; k++) {
            a[k] = 4L * k * k + 1;
        }

        // Sieve with primes up to 2 * limit
        boolean[] isPrime = new boolean[2 * limit + 1];
        java.util.Arrays.fill(isPrime, true);
        for (int p = 2; p <= 2 * limit; p++) {
            if (isPrime[p]) {
                if (p % 4 == 1) {
                    // Find x such that x^2 = -1 mod p
                    long x = tonelliShanks(p - 1, p);
                    // 2k = x mod p or 2k = p-x mod p
                    long inv2 = modInverse(2, p);
                    long k1 = (x * inv2) % p;
                    long k2 = ((p - x) * inv2) % p;
                    
                    for (long k = k1; k <= limit; k += p) if (k > 0) process(k, p, a, pMax);
                    for (long k = k2; k <= limit; k += p) if (k > 0) process(k, p, a, pMax);
                }
                for (int i = 2 * p; i <= 2 * limit; i += p) isPrime[i] = false;
            }
        }

        BigInteger totalSum = BigInteger.ZERO;
        for (int k = 1; k <= limit; k++) {
            long p = Math.max(pMax[k], a[k]);
            totalSum = totalSum.add(BigInteger.valueOf(p));
        }

        String res = totalSum.toString();
        if (res.length() > 18) res = res.substring(res.length() - 18);
        responseDto.setAnswer(res);
        return responseDto;
    }

    private void process(long k, long p, long[] a, long[] pMax) {
        int idx = (int) k;
        if (a[idx] % p == 0) {
            pMax[idx] = Math.max(pMax[idx], p);
            while (a[idx] % p == 0) a[idx] /= p;
        }
    }

    private long tonelliShanks(long n, long p) {
        // Since n = p-1, we need sqrt(-1) mod p
        // For p = 1 mod 4, this is always possible.
        return BigInteger.valueOf(p - 1).modPow(BigInteger.valueOf((p + 1) / 4), BigInteger.valueOf(p)).longValue();
    }

    private long modInverse(long n, long mod) {
        return BigInteger.valueOf(n).modInverse(BigInteger.valueOf(mod)).longValue();
    }
}
// Note: tonelliShanks for sqrt(-1) mod p is just (p-1)^((p+1)/4) if p=3 mod 4 (not the case here)
// For p=1 mod 4, we use (p-1)^((p-1)/4) is wrong. Correct is any non-residue z, z^((p-1)/4).
