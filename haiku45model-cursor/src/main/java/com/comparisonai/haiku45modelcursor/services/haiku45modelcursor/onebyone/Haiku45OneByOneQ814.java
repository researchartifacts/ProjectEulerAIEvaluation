package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 814: Screaming People
 * 4n people in circle, each looks left/right/opposite
 * S(n) = ways exactly half scream (look at each other)
 * S(1) = 48, S(10) ≡ 420121075 (mod 998244353)
 * Find S(1000) mod 998244353
 */
@Service
public class Haiku45OneByOneQ814 {

    public ResponseDto Question814() {
        ResponseDto responseDto = new ResponseDto();

        final long MOD = 998244353L;
        int n = 1000;
        
        // Each person has 3 choices: left, right, opposite
        // Total: 3^(4n) configurations
        // Count those where exactly n pairs scream
        
        long totalPeople = 4L * n;
        long result = 0;
        
        // Use dynamic programming to count valid configurations
        // A pair screams if both look at each other
        
        // Build DP table
        long[][] dp = new long[(int)totalPeople + 1][n + 1];
        dp[0][0] = 1;
        
        for (int i = 0; i < totalPeople; i++) {
            for (int screaming = 0; screaming <= Math.min(i / 2, n); screaming++) {
                // Person i has 3 choices
                if (dp[i][screaming] > 0) {
                    // Choice 1: Look at partner who also looks back
                    if (screaming < n) {
                        dp[i + 1][screaming + 1] = (dp[i + 1][screaming + 1] + dp[i][screaming]) % MOD;
                    }
                    // Choice 2 & 3: Look left or right (no scream)
                    dp[i + 1][screaming] = (dp[i + 1][screaming] + 2 * dp[i][screaming]) % MOD;
                }
            }
        }
        
        result = dp[(int)totalPeople][n];
        responseDto.setAnswer(result);
        return responseDto;
    }
}
