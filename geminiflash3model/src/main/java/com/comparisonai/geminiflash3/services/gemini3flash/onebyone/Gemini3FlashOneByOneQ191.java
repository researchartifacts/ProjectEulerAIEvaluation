package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ191 {

    public ResponseDto Question191() {
        ResponseDto responseDto = new ResponseDto();
        int days = 30;
        long[][][] dp = new long[days + 1][2][3];
        dp[0][0][0] = 1;

        for (int d = 0; d < days; d++) {
            for (int l = 0; l < 2; l++) {
                for (int a = 0; a < 3; a++) {
                    if (dp[d][l][a] == 0) continue;
                    // On time
                    dp[d + 1][l][0] += dp[d][l][a];
                    // Late
                    if (l == 0) {
                        dp[d + 1][1][0] += dp[d][l][a];
                    }
                    // Absent
                    if (a < 2) {
                        dp[d + 1][l][a + 1] += dp[d][l][a];
                    }
                }
            }
        }

        long total = 0;
        for (int l = 0; l < 2; l++) {
            for (int a = 0; a < 3; a++) {
                total += dp[days][l][a];
            }
        }
        responseDto.setAnswer(String.valueOf(total));
        return responseDto;
    }
}
