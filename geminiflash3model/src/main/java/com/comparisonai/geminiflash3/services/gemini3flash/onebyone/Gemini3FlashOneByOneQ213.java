package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class Gemini3FlashOneByOneQ213 {

    public ResponseDto Question213() {
        ResponseDto responseDto = new ResponseDto();
        int size = 30;
        int rings = 50;
        
        double[][] probUnoccupied = new double[size][size];
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                probUnoccupied[r][c] = 1.0;
            }
        }
        
        for (int r0 = 0; r0 < size; r0++) {
            for (int c0 = 0; c0 < size; c0++) {
                double[][] dp = new double[size][size];
                dp[r0][c0] = 1.0;
                
                for (int t = 0; t < rings; t++) {
                    double[][] next = new double[size][size];
                    for (int r = 0; r < size; r++) {
                        for (int c = 0; c < size; c++) {
                            if (dp[r][c] > 0) {
                                List<int[]> neighbors = getNeighbors(r, c, size);
                                double p = dp[r][c] / neighbors.size();
                                for (int[] nb : neighbors) {
                                    next[nb[0]][nb[1]] += p;
                                }
                            }
                        }
                    }
                    dp = next;
                }
                
                for (int r = 0; r < size; r++) {
                    for (int c = 0; c < size; c++) {
                        probUnoccupied[r][c] *= (1.0 - dp[r][c]);
                    }
                }
            }
        }
        
        double expected = 0;
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                expected += probUnoccupied[r][c];
            }
        }
        
        responseDto.setAnswer(String.format("%.6f", expected));
        return responseDto;
    }

    private List<int[]> getNeighbors(int r, int c, int size) {
        List<int[]> res = new ArrayList<>();
        if (r > 0) res.add(new int[]{r - 1, c});
        if (r < size - 1) res.add(new int[]{r + 1, c});
        if (c > 0) res.add(new int[]{r, c - 1});
        if (c < size - 1) res.add(new int[]{r, c + 1});
        return res;
    }
}
