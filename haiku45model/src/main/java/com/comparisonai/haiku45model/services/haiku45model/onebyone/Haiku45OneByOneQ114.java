package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ114 {

    public ResponseDto Question114() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        // Tiling combinations
        long tilings = 0;
        for (int len = 1; len <= 50; len++) {
            long[] dp = new long[len + 1];
            dp[0] = 1;
            for (int i = 1; i <= len; i++) {
                dp[i] = dp[i-1];
                if (i >= 2) dp[i] += dp[i-2];
                if (i >= 3) dp[i] += dp[i-3];
            }
            tilings += dp[len];
        }
        result = tilings;

        responseDto.setAnswer(result);
        return responseDto;
    }
}

