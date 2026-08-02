package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Gemini3FlashOneByOneQ603 {

    private static final long MOD = 1_000_000_007;

    public ResponseDto Question603() {
        ResponseDto responseDto = new ResponseDto();
        
        int n = 1_000_000;
        long k = 1_000_000_000_000L;
        
        List<Integer> primes = getPrimes(n);
        StringBuilder sb = new StringBuilder();
        for (int p : primes) {
            sb.append(p);
        }
        String P = sb.toString();
        int L = P.length();
        
        long sumD = 0;
        long sumDi = 0;
        long sumD10i = 0;
        long inv9 = power(9, MOD - 2);
        
        for (int i = 1; i <= L; i++) {
            int d = P.charAt(i - 1) - '0';
            sumD = (sumD + d) % MOD;
            sumDi = (sumDi + (long) d * i) % MOD;
            sumD10i = (sumD10i + (long) d * power(10, L - i)) % MOD;
        }
        
        long T = (k % MOD * (L % MOD)) % MOD;
        long kMod = k % MOD;
        long LMod = L % MOD;
        
        long term1 = sumDi;
        long term2 = (kMod * (kMod - 1) / 2) % MOD * LMod % MOD * sumD % MOD;
        long totalI = (kMod * term1 + term2) % MOD;
        
        long sum10 = power(10, L);
        long geomSum = (power(sum10, k) - 1 + MOD) % MOD * power(sum10 - 1, MOD - 2) % MOD;
        long totalVal = (sumD10i * geomSum) % MOD;
        
        long ans = (totalVal - totalI + MOD) % MOD * inv9 % MOD;
        
        responseDto.setAnswer(ans);
        return responseDto;
    }

    private List<Integer> getPrimes(int n) {
        List<Integer> primes = new ArrayList<>();
        int limit = 20_000_000; // Rough estimate for 10^6 primes
        boolean[] isPrime = new boolean[limit + 1];
        for (int i = 2; i <= limit; i++) isPrime[i] = true;
        for (int p = 2; p * p <= limit; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i <= limit; i += p) isPrime[i] = false;
            }
        }
        for (int p = 2; p <= limit && primes.size() < n; p++) {
            if (isPrime[p]) primes.add(p);
        }
        return primes;
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
