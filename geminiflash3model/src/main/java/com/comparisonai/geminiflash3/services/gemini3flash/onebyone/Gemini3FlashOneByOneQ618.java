package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ618 {

    private static final long MOD = 1_000_000_000;

    public ResponseDto Question618() {
        ResponseDto responseDto = new ResponseDto();
        
        int maxFib = 46368;
        long[] dp = new long[maxFib + 1];
        dp[0] = 1;
        
        boolean[] isNotPrime = new boolean[maxFib + 1];
        for (int i = 2; i <= maxFib; i++) {
            if (!isNotPrime[i]) {
                for (int j = i; j <= maxFib; j += i) {
                    isNotPrime[j] = true;
                    // Error in logic: should be part of the DP update
                }
                // Correct DP update for G(x) = prod 1/(1 - px^p)
                for (int j = i; j <= maxFib; j++) {
                    dp[j] = (dp[j] + dp[j - i] * i) % MOD;
                }
            }
        }
        
        int[] fib = new int[25];
        fib[1] = 1; fib[2] = 1;
        for (int i = 3; i <= 24; i++) fib[i] = fib[i - 1] + fib[i - 2];
        
        long totalSum = 0;
        for (int i = 2; i <= 24; i++) {
            totalSum = (totalSum + dp[fib[i]]) % MOD;
        }
        
        responseDto.setAnswer(totalSum);
        return responseDto;
    }
}
