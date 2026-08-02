package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 908: Clock Sequence Analysis
 */
@Service
public class Haiku45OneByOneQ908 {

    public ResponseDto Question908() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: C(10^4) - number of clock sequences with period at most N
        // where sequence breaks into segments with sum equal to segment number
        final long MOD = 1111211113L;
        long N = 10000;
        
        // Clock sequence has period P and segments 1,2,3,...
        // where sum of n-th segment equals n
        // Maximum segment is P in the period
        
        long result = 1;
        
        // Dynamic programming: dp[p] = number of sequences with period exactly p
        long[] dp = new long[(int)Math.min(N + 1, 10001)];
        dp[1] = 1; // Single element sequence
        
        for (int p = 2; p <= Math.min(N, 10000); p++) {
            // For period p, we have segments that sum to 1,2,...,p
            // Total sum in period = 1+2+...+p = p(p+1)/2
            // Count compositions of p(p+1)/2 into p parts
            
            long segmentSum = (long) p * (p + 1) / 2;
            long partitions = countCompositions(segmentSum, p);
            dp[p] = partitions % MOD;
        }
        
        result = 0;
        for (int p = 1; p <= Math.min(N, 10000); p++) {
            result = (result + dp[p]) % MOD;
        }

        responseDto.setAnswer(result);
        return responseDto;
    }
    
    private long countCompositions(long sum, int parts) {
        // Count ways to write sum as sum of parts positive integers
        // This is C(sum-1, parts-1) using stars and bars
        if (parts <= 1) return 1;
        if (sum < parts) return 0;
        
        long result = 1;
        for (int i = 0; i < Math.min(parts - 1, sum - parts); i++) {
            result = result * (sum - i) / (i + 1);
        }
        return result;
    }
}
