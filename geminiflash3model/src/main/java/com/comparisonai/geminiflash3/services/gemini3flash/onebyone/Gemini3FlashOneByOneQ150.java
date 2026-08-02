package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ150 {

    public ResponseDto Question150() {
        ResponseDto responseDto = new ResponseDto();
        int rows = 1000;
        int n = rows * (rows + 1) / 2;
        long[] s = new long[n];
        long t = 0;
        for (int k = 1; k <= n; k++) {
            t = (615949 * t + 797807) % (1L << 20);
            s[k - 1] = t - (1L << 19);
        }
        
        long[][] triangle = new long[rows][];
        int idx = 0;
        for (int i = 0; i < rows; i++) {
            triangle[i] = new long[i + 1];
            for (int j = 0; j <= i; j++) {
                triangle[i][j] = s[idx++];
            }
        }
        
        // Precompute prefix sums for each row
        long[][] rowPrefixSum = new long[rows][];
        for (int i = 0; i < rows; i++) {
            rowPrefixSum[i] = new long[i + 2];
            for (int j = 0; j <= i; j++) {
                rowPrefixSum[i][j + 1] = rowPrefixSum[i][j] + triangle[i][j];
            }
        }
        
        long minSum = Long.MAX_VALUE;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j <= i; j++) {
                long currentSubTriangleSum = 0;
                for (int h = 0; i + h < rows; h++) {
                    currentSubTriangleSum += rowPrefixSum[i + h][j + h + 1] - rowPrefixSum[i + h][j];
                    if (currentSubTriangleSum < minSum) {
                        minSum = currentSubTriangleSum;
                    }
                }
            }
        }
        
        responseDto.setAnswer(minSum);
        return responseDto;
    }
}
