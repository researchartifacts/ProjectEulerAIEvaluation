package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ115 {

    public ResponseDto Question115() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        // Tiling with blocks
        long tilingCombos = 0;
        for (int m = 2; m <= 50; m++) {
            long[] dp = new long[m + 1];
            dp[0] = 1;
            for (int i = 1; i <= m; i++) {
                dp[i] = dp[i-1];
                if (i >= m) dp[i] += dp[i-m];
            }
            tilingCombos += dp[m];
        }
        result = tilingCombos;

        responseDto.setAnswer(result);
        return responseDto;
    }
}

