package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ116 {

    public ResponseDto Question116() {
        ResponseDto responseDto = new ResponseDto();
        int n = 50;
        long total = countWays(n, 2) + countWays(n, 3) + countWays(n, 4);
        responseDto.setAnswer(String.valueOf(total));
        return responseDto;
    }

    private long countWays(int n, int m) {
        long[] dp = new long[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1]; // Grey tile
            if (i >= m) {
                dp[i] += dp[i - m]; // Coloured tile
            }
        }
        return dp[n] - 1; // At least one coloured tile
    }
}
