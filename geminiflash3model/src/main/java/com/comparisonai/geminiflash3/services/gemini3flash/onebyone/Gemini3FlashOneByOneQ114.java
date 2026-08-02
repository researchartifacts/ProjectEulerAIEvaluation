package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ114 {

    public ResponseDto Question114() {
        ResponseDto responseDto = new ResponseDto();
        int n = 50;
        long[] ways = new long[n + 1];
        for (int i = 0; i <= n; i++) {
            ways[i] = 1; // All grey
            for (int len = 3; len <= i; len++) {
                for (int pos = 0; pos <= i - len; pos++) {
                    int remaining = i - len - pos - 1;
                    ways[i] += (remaining < 0) ? 1 : ways[remaining];
                }
            }
        }
        // Correct dynamic programming: ways[i] = ways[i-1] + sum_{len=3}^{i} ways[i-len-1] (with ways[-1]=1)
        long[] dp = new long[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1]; // Start with grey square
            for (int len = 3; len <= i; len++) {
                if (i - len - 1 >= 0) {
                    dp[i] += dp[i - len - 1];
                } else if (i - len == 0) {
                    dp[i] += 1;
                }
            }
        }
        responseDto.setAnswer(String.valueOf(dp[n]));
        return responseDto;
    }
}
