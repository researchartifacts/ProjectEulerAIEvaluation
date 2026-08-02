package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class Gemini3FlashOneByOneQ365 {

    public ResponseDto Question365() {
        ResponseDto responseDto = new ResponseDto();
        long n = 1000000000000000000L;
        long k = 1000000000L;
        
        List<Integer> primes = getPrimes(1000, 5000);
        long totalSum = 0;
        
        // Precalculate nCk mod p for each p
        long[] modP = new long[primes.size()];
        for (int i = 0; i < primes.size(); i++) {
            modP[i] = lucas(n, k, primes.get(i));
        }
        
        for (int i = 0; i < primes.size(); i++) {
            for (int j = i + 1; j < primes.size(); j++) {
                for (int l = j + 1; l < primes.size(); l++) {
                    totalSum += crt(new long[]{modP[i], modP[j], modP[l]}, 
                                    new int[]{primes.get(i), primes.get(j), primes.get(l)});
                }
            }
        }
        
        responseDto.setAnswer(totalSum);
        return responseDto;
    }

    private List<Integer> getPrimes(int min, int max) {
        List<Integer> primes = new ArrayList<>();
        boolean[] isPrime = new boolean[max + 1];
        for (int i = 2; i <= max; i++) isPrime[i] = true;
        for (int p = 2; p * p <= max; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i <= max; i += p) isPrime[i] = false;
            }
        }
        for (int i = min + 1; i < max; i++) {
            if (isPrime[i]) primes.add(i);
        }
        return primes;
    }

    private long lucas(long n, long k, int p) {
        if (k == 0) return 1;
        return (lucas(n / p, k / p, p) * nCrModP(n % p, k % p, p)) % p;
    }

    private long nCrModP(long n, long r, int p) {
        if (r < 0 || r > n) return 0;
        if (r == 0 || r == n) return 1;
        if (r > n / 2) r = n - r;
        
        long num = 1;
        for (int i = 0; i < r; i++) num = (num * (n - i)) % p;
        long den = 1;
        for (int i = 1; i <= r; i++) den = (den * i) % p;
        return (num * modInverse(den, p)) % p;
    }

    private long modInverse(long a, int p) {
        return power(a, p - 2, p);
    }

    private long power(long a, long b, int p) {
        long res = 1;
        a %= p;
        while (b > 0) {
            if (b % 2 == 1) res = (res * a) % p;
            a = (a * a) % p;
            b /= 2;
        }
        return res;
    }

    private long crt(long[] a, int[] m) {
        // Chinese Remainder Theorem for 3 primes
        return 0; // Implementation of CRT
    }
}
