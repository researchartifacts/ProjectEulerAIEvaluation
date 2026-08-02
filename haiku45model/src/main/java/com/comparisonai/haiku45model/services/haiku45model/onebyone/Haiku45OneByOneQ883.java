package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ883 {

    public ResponseDto Question883() {
        ResponseDto responseDto = new ResponseDto();

        long result = 0;
        for (int i = 1; i <= 100; i++) {
            result += bellNumber(i);
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    private long bellNumber(int n) {
        long[][] bell = new long[n + 1][n + 1];
        bell[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            bell[i][0] = bell[i - 1][i - 1];
            for (int j = 1; j <= i; j++) {
                bell[i][j] = bell[i][j - 1] + bell[i - 1][j - 1];
            }
        }
        return bell[n][0];
    }
}
