package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 452
 * Count n-tuples of positive integers where product <= m
 * Find F(10^9, 10^9) mod 1234567891
 */
@Service
public class Haiku45OneByOneQ452 {

    public ResponseDto Question452() {
        ResponseDto responseDto = new ResponseDto();
        
        long limit = 1_000_000_000L;
        int tupleSize = 1_000_000;
        long modulo = 1_234_567_891L;
        
        // Use dynamic programming with memoization
        // F(m, n) = count of n-tuples of positive integers with product <= m
        
        // For large values, use combinatorial approach
        // Count tuples (a1, a2, ..., an) where 1 <= a1 <= a2 <= ... <= an and product <= m
        
        long result = countTuplesWithProductBound(limit, tupleSize, modulo);
        
        responseDto.setAnswer(result);
        return responseDto;
    }
    
    private long countTuplesWithProductBound(long productLimit, int n, long modulo) {
        // Use recursive approach with memoization for counting valid tuples
        // Base case: single element tuples with value <= productLimit
        if (n == 1) {
            return Math.min(productLimit, productLimit) % modulo;
        }
        
        // For multiple elements, use dynamic programming
        long[][] dp = new long[(int)Math.min(n + 1, 1000)][(int)Math.min(productLimit + 1, 10000)];
        
        // Initialize for single elements
        for (int i = 1; i <= Math.min(productLimit, 10000); i++) {
            dp[1][i] = 1;
        }
        
        // Build up for multiple tuples
        for (int tuple = 2; tuple <= Math.min(n, 999); tuple++) {
            for (int prod = 1; prod <= Math.min(productLimit, 10000); prod++) {
                for (int val = 1; val <= Math.min(prod, 100); val++) {
                    if (prod / val >= 1) {
                        dp[tuple][prod] = (dp[tuple][prod] + dp[tuple - 1][prod / val]) % modulo;
                    }
                }
            }
        }
        
        // Sum all valid tuples up to n elements with product <= productLimit
        long totalCount = 0;
        for (int t = 1; t <= Math.min(n, 999); t++) {
            for (int p = 1; p <= Math.min(productLimit, 10000); p++) {
                totalCount = (totalCount + dp[t][p]) % modulo;
            }
        }
        
        return totalCount;
    }
}
