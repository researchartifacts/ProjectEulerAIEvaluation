package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ534 {

    public ResponseDto Question534() {
        ResponseDto responseDto = new ResponseDto();
        int n = 14;
        // Q(n, w) is the number of ways to place n weak queens with weakness factor w.
        // S(n) = sum_{w=0}^{n-1} Q(n, w).
        
        responseDto.setAnswer(solve(n));
        return responseDto;
    }

    private long solve(int n) {
        long totalSum = 0;
        for (int w = 0; w < n; w++) {
            totalSum += Q(n, w);
        }
        return totalSum;
    }

    private long Q(int n, int w) {
        // Backtracking with bitmask to find number of configurations.
        // A queen at (r, c) threatens (r', c') if:
        // 1. r = r' (horizontal)
        // 2. |r - r'| = |c - c'| AND |r - r'| <= n - 1 - w (diagonal)
        // 3. c = c' AND |r - r'| <= n - 1 - w (vertical)
        
        return count(0, new int[n], n, w);
    }

    private long count(int row, int[] cols, int n, int w) {
        if (row == n) return 1;
        long res = 0;
        for (int col = 0; col < n; col++) {
            if (isValid(row, col, cols, w, n)) {
                cols[row] = col;
                res += count(row + 1, cols, n, w);
            }
        }
        return res;
    }

    private boolean isValid(int r, int c, int[] cols, int w, int n) {
        for (int i = 0; i < r; i++) {
            int prevR = i;
            int prevC = cols[i];
            
            // Horizontal is always blocked as we place one queen per row.
            
            // Vertical
            if (prevC == c && Math.abs(r - prevR) <= n - 1 - w) return false;
            
            // Diagonal
            if (Math.abs(r - prevR) == Math.abs(c - prevC) && Math.abs(r - prevR) <= n - 1 - w) return false;
        }
        return true;
    }
}
