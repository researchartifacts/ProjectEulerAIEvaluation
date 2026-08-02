package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ15 {

    public ResponseDto Question15() {
        ResponseDto responseDto = new ResponseDto();
        int gridSize = 20;
        long[][] grid = new long[gridSize + 1][gridSize + 1];
        for (int i = 0; i <= gridSize; i++) {
            grid[i][0] = 1;
            grid[0][i] = 1;
        }
        for (int i = 1; i <= gridSize; i++) {
            for (int j = 1; j <= gridSize; j++) {
                grid[i][j] = grid[i - 1][j] + grid[i][j - 1];
            }
        }
        responseDto.setAnswer(grid[gridSize][gridSize]);
        return responseDto;
    }
}
