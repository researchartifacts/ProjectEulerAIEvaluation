package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class Haiku45OneByOneQ840 {

    public ResponseDto Question840() {
        ResponseDto responseDto = new ResponseDto();

        long result = 0;
        int n = 100;

        for (int i = 1; i <= n; i++) {
            result += countPartitions(i);
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    private long countPartitions(int n) {
        long[] dp = new long[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                dp[j] += dp[j - i];
            }
        }

        return dp[n];
    }
}
