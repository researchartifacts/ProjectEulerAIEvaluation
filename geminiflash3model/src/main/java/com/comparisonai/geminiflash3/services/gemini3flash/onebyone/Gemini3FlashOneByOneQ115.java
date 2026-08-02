package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ115 {

    public ResponseDto Question115() {
        ResponseDto responseDto = new ResponseDto();
        int m = 50;
        for (int n = m; ; n++) {
            if (f(m, n) > 1000000) {
                responseDto.setAnswer(String.valueOf(n));
                break;
            }
        }
        return responseDto;
    }

    private long f(int m, int n) {
        long[] dp = new long[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1];
            for (int len = m; len <= i; len++) {
                if (i - len - 1 >= 0) {
                    dp[i] += dp[i - len - 1];
                } else if (i - len == 0) {
                    dp[i] += 1;
                }
            }
        }
        return dp[n];
    }
}
