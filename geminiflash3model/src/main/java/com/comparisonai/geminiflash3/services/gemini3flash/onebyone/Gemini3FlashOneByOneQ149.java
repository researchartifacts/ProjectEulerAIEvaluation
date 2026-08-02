package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ149 {

    public ResponseDto Question149() {
        ResponseDto responseDto = new ResponseDto();
        int size = 2000;
        long[] s = new long[size * size + 1];
        
        for (int k = 1; k <= 55; k++) {
            s[k] = (100003L - 200003L * k + 300007L * k * k * k) % 1000000;
            if (s[k] < 0) s[k] += 1000000;
            s[k] -= 500000;
        }
        for (int k = 56; k <= size * size; k++) {
            s[k] = (s[k - 24] + s[k - 55] + 1000000) % 1000000;
            if (s[k] < 0) s[k] += 1000000;
            s[k] -= 500000;
        }
        
        long[][] grid = new long[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = s[i * size + j + 1];
            }
        }
        
        long maxVal = 0;
        // Horizontal
        for (int i = 0; i < size; i++) {
            long current = 0;
            for (int j = 0; j < size; j++) {
                current = Math.max(0, current + grid[i][j]);
                maxVal = Math.max(maxVal, current);
            }
        }
        // Vertical
        for (int j = 0; j < size; j++) {
            long current = 0;
            for (int i = 0; i < size; i++) {
                current = Math.max(0, current + grid[i][j]);
                maxVal = Math.max(maxVal, current);
            }
        }
        // Diagonal
        for (int k = 0; k < 2 * size - 1; k++) {
            long current1 = 0; // top-left to bottom-right
            long current2 = 0; // top-right to bottom-left
            for (int i = 0; i < size; i++) {
                int j1 = k - i;
                if (j1 >= 0 && j1 < size) {
                    current1 = Math.max(0, current1 + grid[i][j1]);
                    maxVal = Math.max(maxVal, current1);
                }
                int j2 = i - (k - (size - 1));
                if (j2 >= 0 && j2 < size) {
                    current2 = Math.max(0, current2 + grid[i][j2]);
                    maxVal = Math.max(maxVal, current2);
                }
            }
        }
        
        responseDto.setAnswer(maxVal);
        return responseDto;
    }
}
