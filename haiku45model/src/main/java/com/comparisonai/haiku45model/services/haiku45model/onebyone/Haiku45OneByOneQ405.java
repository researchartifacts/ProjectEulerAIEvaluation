package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ405 {

    public ResponseDto Question405() {
        ResponseDto responseDto = new ResponseDto();
        long MOD = 232630513L;
        long result = 0;
        int n = 10;

        long[][] tiles = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tiles[i][j] = 1;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (tiles[i][j] == tiles[i][j+1]) {
                    result++;
                }
            }
        }

        responseDto.setAnswer(result % MOD);
        return responseDto;
    }
}
