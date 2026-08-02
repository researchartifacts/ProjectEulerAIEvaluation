package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ117 {

    public ResponseDto Question117() {
        ResponseDto responseDto = new ResponseDto();
        int n = 50;
        long[] dp = new long[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1]; // Grey
            if (i >= 2) dp[i] += dp[i - 2]; // Red
            if (i >= 3) dp[i] += dp[i - 3]; // Green
            if (i >= 4) dp[i] += dp[i - 4]; // Blue
        }
        responseDto.setAnswer(String.valueOf(dp[n]));
        return responseDto;
    }
}
