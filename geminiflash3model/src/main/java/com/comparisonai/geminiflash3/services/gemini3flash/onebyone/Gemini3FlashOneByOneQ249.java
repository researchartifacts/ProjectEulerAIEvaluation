package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class Gemini3FlashOneByOneQ249 {

    public ResponseDto Question249() {
        ResponseDto responseDto = new ResponseDto();
        int limit = 5000;
        List<Integer> primes = getPrimes(limit);
        int maxSum = 0;
        for (int p : primes) maxSum += p;
        
        long[] dp = new long[maxSum + 1];
        dp[0] = 1;
        long mod = 10_000_000_000_000_000L;
        
        for (int p : primes) {
            for (int s = maxSum; s >= p; s--) {
                dp[s] = (dp[s] + dp[s - p]) % mod;
            }
        }
        
        long total = 0;
        boolean[] isSumPrime = getPrimeArray(maxSum);
        for (int s = 2; s <= maxSum; s++) {
            if (isSumPrime[s]) {
                total = (total + dp[s]) % mod;
            }
        }
        
        responseDto.setAnswer(total);
        return responseDto;
    }

    private List<Integer> getPrimes(int limit) {
        List<Integer> res = new ArrayList<>();
        boolean[] isPrime = new boolean[limit + 1];
        Arrays.fill(isPrime, true);
        for (int p = 2; p <= limit; p++) {
            if (isPrime[p]) {
                res.add(p);
                for (int i = p * 2; i <= limit; i += p) isPrime[i] = false;
            }
        }
        return res;
    }

    private boolean[] getPrimeArray(int limit) {
        boolean[] isPrime = new boolean[limit + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int p = 2; p * p <= limit; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i <= limit; i += p) isPrime[i] = false;
            }
        }
        return isPrime;
    }
}
