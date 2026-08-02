package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ15 {

    public ResponseDto Question15() {
        ResponseDto responseDto = new ResponseDto();
        long[][] grid = new long[21][21];
        for (int i = 0; i <= 20; i++) {
            grid[i][0] = 1;
            grid[0][i] = 1;
        }
        for (int i = 1; i <= 20; i++) {
            for (int j = 1; j <= 20; j++) {
                grid[i][j] = grid[i-1][j] + grid[i][j-1];
            }
        }
        responseDto.setAnswer(grid[20][20]);
        return responseDto;
    }
}
