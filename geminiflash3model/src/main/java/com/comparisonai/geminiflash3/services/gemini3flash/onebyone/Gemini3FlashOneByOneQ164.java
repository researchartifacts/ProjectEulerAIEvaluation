package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ164 {

    public ResponseDto Question164() {
        ResponseDto responseDto = new ResponseDto();
        // 20-digit numbers where no three consecutive digits sum > 9.
        // Using DP: dp[len][digit1][digit2]
        long[][][] dp = new long[21][10][10];
        
        for (int i = 1; i <= 9; i++) {
            for (int j = 0; j <= 9 - i; j++) {
                dp[2][i][j] = 1;
            }
        }
        
        for (int len = 2; len < 20; len++) {
            for (int d1 = 0; d1 <= 9; d1++) {
                for (int d2 = 0; d2 <= 9 - d1; d2++) {
                    if (dp[len][d1][d2] == 0) continue;
                    for (int d3 = 0; d3 <= 9 - d1 - d2; d3++) {
                        dp[len + 1][d2][d3] += dp[len][d1][d2];
                    }
                }
            }
        }
        
        long total = 0;
        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j <= 9; j++) {
                total += dp[20][i][j];
            }
        }
        
        responseDto.setAnswer(String.valueOf(total));
        return responseDto;
    }
}
