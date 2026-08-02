package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ825 {

    public ResponseDto Question825() {
        ResponseDto responseDto = new ResponseDto();

        long n = 100000000000000L;
        double result = calculateTotalWinProbability(n);

        responseDto.setAnswer(Math.round(result * 100000000.0) / 100000000.0);
        return responseDto;
    }

    private double calculateTotalWinProbability(long maxN) {
        double total = 0;
        for (long n = 2; n <= Math.min(maxN, 1000); n++) {
            double s = calculateSForN(n);
            total += s;
        }
        return total;
    }

    private double calculateSForN(long n) {
        double[][] dp = new double[2][(int) (n + 1)];

        for (int pos = 0; pos <= n; pos++) {
            if (pos >= n) {
                dp[0][pos] = 1.0;
            } else if (pos <= 0) {
                dp[1][pos] = 1.0;
            }
        }

        for (int turn = 1; turn < n; turn++) {
            for (int pos = 1; pos < n; pos++) {
                double move1 = (pos + 1 > n) ? 1.0 : (1.0 - dp[1][pos + 1]);
                double move2 = (pos + 2 > n) ? 1.0 : (1.0 - dp[1][pos + 2]);
                double move3 = (pos + 3 > n) ? 1.0 : (1.0 - dp[1][pos + 3]);
                dp[turn % 2][pos] = (move1 + move2 + move3) / 3.0;
            }
        }

        return Math.abs(dp[(int) (n % 2)][0] - dp[(int) ((n + 1) % 2)][0]);
    }
}
