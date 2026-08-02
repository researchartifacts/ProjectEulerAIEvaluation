package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ217 {

    public ResponseDto Question217() {
        ResponseDto responseDto = new ResponseDto();
        int maxN = 47;
        long MOD = (long) Math.pow(3, 15);
        
        long totalSum = 0;
        for (int n = 1; n <= maxN; n++) {
            totalSum = (totalSum + getBalancedSum(n, MOD)) % MOD;
        }
        
        responseDto.setAnswer(totalSum);
        return responseDto;
    }

    private long getBalancedSum(int n, long mod) {
        int half = (n + 1) / 2;
        int maxSum = 9 * half;
        
        // dpCount[i][s] = number of i-digit numbers with digit sum s
        // dpSum[i][s] = sum of i-digit numbers with digit sum s
        long[][] dpCount = new long[half + 1][maxSum + 1];
        long[][] dpSum = new long[half + 1][maxSum + 1];
        
        dpCount[0][0] = 1;
        long[] p10 = new long[half + 1];
        p10[0] = 1;
        for (int i = 1; i <= half; i++) p10[i] = (p10[i-1] * 10) % mod;

        for (int i = 1; i <= half; i++) {
            for (int s = 0; s <= maxSum; s++) {
                for (int d = 0; d <= 9; d++) {
                    if (s >= d) {
                        dpCount[i][s] = (dpCount[i][s] + dpCount[i - 1][s - d]) % mod;
                        long term = (dpSum[i - 1][s - d] * 10 + dpCount[i - 1][s - d] * d) % mod;
                        dpSum[i][s] = (dpSum[i][s] + term) % mod;
                    }
                }
            }
        }

        // Special handling for the first half (no leading zeros)
        long[][] dpCountNoLeading = new long[half + 1][maxSum + 1];
        long[][] dpSumNoLeading = new long[half + 1][maxSum + 1];
        dpCountNoLeading[0][0] = 1;
        for (int i = 1; i <= half; i++) {
            for (int s = 0; s <= maxSum; s++) {
                for (int d = (i == half ? 1 : 0); d <= 9; d++) {
                    if (s >= d) {
                        dpCountNoLeading[i][s] = (dpCountNoLeading[i][s] + dpCount[i - 1][s - d]) % mod;
                        long term = (dpSum[i - 1][s - d] + dpCount[i - 1][s - d] * (long)d * p10[i-1]) % mod;
                        dpSumNoLeading[i][s] = (dpSumNoLeading[i][s] + term) % mod;
                    }
                }
            }
        }

        long res = 0;
        int secondHalf = n / 2;
        for (int s = 0; s <= maxSum; s++) {
            if (s <= 9 * secondHalf) {
                // First half (with leading zeros disallowed) + Second half
                // Sum = Sum(FirstHalf) * Count(SecondHalf) * 10^(secondHalf) + Count(FirstHalf) * Sum(SecondHalf)
                long c1 = dpCountNoLeading[half][s];
                long s1 = dpSumNoLeading[half][s];
                long c2 = dpCount[secondHalf][s];
                long s2 = dpSum[secondHalf][s];
                
                long term1 = (s1 * c2 % mod * p10[secondHalf] % mod);
                long term2 = (c1 * s2 % mod);
                res = (res + term1 + term2) % mod;
            }
        }
        return res;
    }
}
