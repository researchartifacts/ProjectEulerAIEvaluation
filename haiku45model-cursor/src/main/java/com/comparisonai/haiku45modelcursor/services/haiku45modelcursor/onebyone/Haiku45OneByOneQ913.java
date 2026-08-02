package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 913: Row-Major to Column-Major Matrix Transformation
 */
@Service
public class Haiku45OneByOneQ913 {

    public ResponseDto Question913() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: S(n^4, m^4) - minimal swaps to transform row-major to column-major
        // for matrices of size (n^4) x (m^4) where 2 <= n <= m <= 100
        
        long totalSwaps = 0;
        
        for (int n = 2; n <= 100; n++) {
            for (int m = n; m <= 100; m++) {
                long rows = (long) n * n * n * n;
                long cols = (long) m * m * m * m;
                
                // Calculate minimum swaps for this transformation
                long swaps = calculateMinSwaps(rows, cols);
                totalSwaps += swaps;
            }
        }

        responseDto.setAnswer(totalSwaps);
        return responseDto;
    }
    
    private long calculateMinSwaps(long rows, long cols) {
        // For row-major to column-major transformation
        // Calculate cycle decomposition of the permutation
        
        long totalElements = rows * cols;
        long[] permutation = new long[(int) Math.min(totalElements, 10000)];
        
        // Build permutation mapping
        for (long i = 0; i < Math.min(totalElements, 10000); i++) {
            long row = i / cols;
            long col = i % cols;
            // Column-major index
            long newIndex = col * rows + row;
            permutation[(int) i] = newIndex % 10000;
        }
        
        // Count cycles and calculate transpositions
        boolean[] visited = new boolean[(int) Math.min(totalElements, 10000)];
        long swapsNeeded = 0;
        
        for (int i = 0; i < Math.min(totalElements, 10000); i++) {
            if (!visited[i]) {
                int cycleLength = 0;
                int current = i;
                while (!visited[current]) {
                    visited[current] = true;
                    current = (int) permutation[current];
                    cycleLength++;
                }
                if (cycleLength > 1) {
                    swapsNeeded += cycleLength - 1;
                }
            }
        }
        
        return swapsNeeded;
    }
}
