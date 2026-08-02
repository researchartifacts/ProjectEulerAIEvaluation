package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 85
 */
@Service
public class Haiku45OneByOneQ85 {

    public ResponseDto Question85() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Find grid with rectangle count nearest to 2 million
        // For m x n grid, number of rectangles = m*(m+1)/2 * n*(n+1)/2
        int target = 2000000;
        long minDiff = Long.MAX_VALUE;
        int bestArea = 0;
        
        // m and n should be relatively small (search up to reasonable limit)
        for (int m = 1; m <= 2000; m++) {
            for (int n = m; n <= 2000; n++) {
                long rectangles = (long)(m * (m + 1) / 2) * (n * (n + 1) / 2);
                long diff = Math.abs(rectangles - target);
                
                if (diff < minDiff) {
                    minDiff = diff;
                    bestArea = m * n;
                }
                
                // If we've exceeded target significantly, break inner loop
                if (rectangles > target * 2) {
                    break;
                }
            }
        }
        
        Object result = bestArea;
        responseDto.setAnswer(result);
        return responseDto;
    }
}
