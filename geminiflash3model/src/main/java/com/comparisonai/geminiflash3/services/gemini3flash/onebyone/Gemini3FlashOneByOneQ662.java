package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Gemini3FlashOneByOneQ662 {

    public ResponseDto Question662() {
        ResponseDto responseDto = new ResponseDto();

        int W = 10000, H = 10000;
        long mod = 1000000007;

        List<int[]> steps = new ArrayList<>();
        long[] fib = new long[25];
        fib[0] = 1; fib[1] = 2;
        for (int i = 2; i < 25; i++) fib[i] = fib[i - 1] + fib[i - 2];

        for (long f : fib) {
            long f2 = f * f;
            for (int x = 0; x * x <= f2; x++) {
                int y2 = (int) (f2 - x * x);
                int y = (int) Math.sqrt(y2);
                if (y * y == y2) {
                    steps.add(new int[]{x, y});
                }
            }
        }

        long[][] dp = new long[W + 1][H + 1];
        dp[0][0] = 1;

        for (int i = 0; i <= W; i++) {
            for (int j = 0; j <= H; j++) {
                if (dp[i][j] == 0) continue;
                for (int[] step : steps) {
                    int ni = i + step[0];
                    int nj = j + step[1];
                    if (ni <= W && nj <= H && (step[0] > 0 || step[1] > 0)) {
                        dp[ni][nj] = (dp[ni][nj] + dp[i][j]) % mod;
                    }
                }
            }
        }

        responseDto.setAnswer(dp[W][H]);
        return responseDto;
    }
}
