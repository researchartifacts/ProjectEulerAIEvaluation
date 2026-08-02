package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ31 {

    public ResponseDto Question31() {
        ResponseDto responseDto = new ResponseDto();
        int[] coins = {1, 2, 5, 10, 20, 50, 100, 200};
        int[] dp = new int[201];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= 200; i++) {
                dp[i] += dp[i - coin];
            }
        }
        responseDto.setAnswer(dp[200]);
        return responseDto;
    }
}
