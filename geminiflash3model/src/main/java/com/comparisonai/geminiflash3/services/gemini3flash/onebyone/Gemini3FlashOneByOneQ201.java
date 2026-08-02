package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ201 {

    public ResponseDto Question201() {
        ResponseDto responseDto = new ResponseDto();
        int n = 100;
        int k = 50;
        int[] squares = new int[n + 1];
        for (int i = 1; i <= n; i++) squares[i] = i * i;

        int maxSum = 0;
        for (int i = n; i > n - k; i--) maxSum += squares[i];

        // dp[c][s] = number of ways to get sum s with c elements
        // Use byte to store 0, 1, or 2 (2 meaning >1)
        byte[][] dp = new byte[k + 1][maxSum + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            int sq = squares[i];
            for (int c = Math.min(i, k); c >= 1; c--) {
                for (int s = maxSum; s >= sq; s--) {
                    if (dp[c - 1][s - sq] > 0) {
                        int current = dp[c][s] + dp[c - 1][s - sq];
                        dp[c][s] = (byte) Math.min(current, 2);
                    }
                }
            }
        }

        long totalSum = 0;
        for (int s = 0; s <= maxSum; s++) {
            if (dp[k][s] == 1) {
                totalSum += s;
            }
        }

        responseDto.setAnswer(totalSum);
        return responseDto;
    }
}
