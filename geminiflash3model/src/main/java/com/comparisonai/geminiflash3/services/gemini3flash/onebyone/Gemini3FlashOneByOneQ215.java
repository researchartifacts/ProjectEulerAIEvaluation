package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class Gemini3FlashOneByOneQ215 {

    public ResponseDto Question215() {
        ResponseDto responseDto = new ResponseDto();
        int width = 32;
        int height = 10;
        
        List<Integer> rows = new ArrayList<>();
        generateRows(0, width, 0, rows);
        
        int n = rows.size();
        long[][] adj = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((rows.get(i) & rows.get(j)) == 0) {
                    adj[i][j] = 1;
                }
            }
        }
        
        long[] dp = new long[n];
        Arrays.fill(dp, 1);
        for (int h = 1; h < height; h++) {
            long[] next = new long[n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (adj[i][j] == 1) {
                        next[i] += dp[j];
                    }
                }
            }
            dp = next;
        }
        
        long total = 0;
        for (long count : dp) total += count;
        
        responseDto.setAnswer(total);
        return responseDto;
    }

    private void generateRows(int currentWidth, int targetWidth, int mask, List<Integer> rows) {
        if (currentWidth == targetWidth) {
            // Remove the last gap (at width)
            rows.add(mask & ~(1 << (targetWidth - 1)));
            return;
        }
        if (currentWidth + 2 <= targetWidth) {
            generateRows(currentWidth + 2, targetWidth, mask | (1 << (currentWidth + 1)), rows);
        }
        if (currentWidth + 3 <= targetWidth) {
            generateRows(currentWidth + 3, targetWidth, mask | (1 << (currentWidth + 2)), rows);
        }
    }
}
