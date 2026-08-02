package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class Gemini3FlashOneByOneQ121 {

    public ResponseDto Question121() {
        ResponseDto responseDto = new ResponseDto();
        int turns = 15;
        // dp[i][j] is the number of ways to have j blue discs after i turns
        // total outcomes = (turns + 1)!
        BigInteger[][] dp = new BigInteger[turns + 1][turns + 1];
        for (int i = 0; i <= turns; i++) {
            for (int j = 0; j <= turns; j++) {
                dp[i][j] = BigInteger.ZERO;
            }
        }
        dp[0][0] = BigInteger.ONE;

        for (int i = 1; i <= turns; i++) {
            int redDiscs = i;
            int blueDiscs = 1;
            for (int j = 0; j < i; j++) {
                // Pick red
                dp[i][j] = dp[i][j].add(dp[i - 1][j].multiply(BigInteger.valueOf(redDiscs)));
                // Pick blue
                dp[i][j + 1] = dp[i][j + 1].add(dp[i - 1][j].multiply(BigInteger.valueOf(blueDiscs)));
            }
        }

        BigInteger winningOutcomes = BigInteger.ZERO;
        for (int j = turns / 2 + 1; j <= turns; j++) {
            winningOutcomes = winningOutcomes.add(dp[turns][j]);
        }

        BigInteger totalOutcomes = BigInteger.ONE;
        for (int i = 2; i <= turns + 1; i++) {
            totalOutcomes = totalOutcomes.multiply(BigInteger.valueOf(i));
        }

        BigInteger prizeFund = totalOutcomes.divide(winningOutcomes);
        responseDto.setAnswer(prizeFund.toString());
        return responseDto;
    }
}
