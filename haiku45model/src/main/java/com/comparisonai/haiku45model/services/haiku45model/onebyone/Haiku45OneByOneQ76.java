package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ76 {

    public ResponseDto Question76() {
        ResponseDto responseDto = new ResponseDto();
        long[] dp = new long[101];
        dp[0] = 1;
        for (int i = 1; i < 100; i++) {
            for (int j = i; j <= 100; j++) {
                dp[j] += dp[j - i];
            }
        }
        responseDto.setAnswer(dp[100] - 1);
        return responseDto;
    }
}
