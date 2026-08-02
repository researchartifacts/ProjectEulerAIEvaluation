package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ78 {

    public ResponseDto Question78() {
        ResponseDto responseDto = new ResponseDto();
        long[] dp = new long[100001];
        dp[0] = 1;
        for (int n = 1; n <= 100000; n++) {
            for (int k = n; k <= 100000; k++) {
                dp[k] = (dp[k] + dp[k - n]) % 1000000;
            }
            if (dp[n] % 1000000 == 0 && n > 1) {
                responseDto.setAnswer(n);
                return responseDto;
            }
        }
        return responseDto;
    }
}
