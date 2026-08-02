package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;

@Service
public class Gemini3FlashOneByOneQ181 {

    public ResponseDto Question181() {
        ResponseDto responseDto = new ResponseDto();
        int bLimit = 60;
        int wLimit = 40;
        
        BigInteger[][] dp = new BigInteger[bLimit + 1][wLimit + 1];
        for (int i = 0; i <= bLimit; i++) {
            for (int j = 0; j <= wLimit; j++) {
                dp[i][j] = BigInteger.ZERO;
            }
        }
        dp[0][0] = BigInteger.ONE;

        for (int b = 0; b <= bLimit; b++) {
            for (int w = 0; w <= wLimit; w++) {
                if (b == 0 && w == 0) continue;
                for (int i = b; i <= bLimit; i++) {
                    for (int j = w; j <= wLimit; j++) {
                        dp[i][j] = dp[i][j].add(dp[i - b][j - w]);
                    }
                }
            }
        }
        
        responseDto.setAnswer(dp[bLimit][wLimit].toString());
        return responseDto;
    }
}
