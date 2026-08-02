package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ819 {

    public ResponseDto Question819() {
        ResponseDto responseDto = new ResponseDto();

        int n = 1000;
        double expectedSteps = calculateExpectedSteps(n);

        responseDto.setAnswer(Math.round(expectedSteps * 1000000.0) / 1000000.0);
        return responseDto;
    }

    private double calculateExpectedSteps(int n) {
        double expectedValue = 0;
        double[] dp = new double[n + 1];

        for (int i = 1; i <= n; i++) {
            double probability = (double) i / n;
            dp[i] = 1 + (1 - probability) * dp[i];
        }

        for (int i = 1; i <= n; i++) {
            expectedValue += dp[i];
        }

        return expectedValue;
    }
}
