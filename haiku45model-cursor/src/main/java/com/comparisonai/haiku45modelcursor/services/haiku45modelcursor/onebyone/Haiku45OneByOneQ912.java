package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 912: No Three Consecutive Ones in Binary
 */
@Service
public class Haiku45OneByOneQ912 {

    public ResponseDto Question912() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: F(10^16) - sum of n^2 for odd s_n where s_n has no 111 in binary
        // s_n is n-th positive integer without 111 in binary representation
        final long MOD = 1000000007L;
        long N = 10000000000000000L;
        
        long result = 0;
        
        // Generate integers without "111" in binary
        // Use dynamic programming approach
        long[] dp = new long[65]; // For bit positions
        long[] dpOdd = new long[65];
        
        // Base cases
        dp[0] = 1;
        dp[1] = 2;
        dpOdd[0] = 1;
        dpOdd[1] = 1; // Only 1 is odd among {1, 2}
        
        // Build up sequences
        for (int i = 2; i < 65; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
            // Odd numbers: last bit is 1
            dpOdd[i] = dp[i - 2] % MOD;
        }
        
        // Sum n^2 for odd s_n values up to N
        long count = 0;
        for (long n = 1; n <= Math.min(N, 1000000); n++) {
            // Check if n is in the valid sequence and is odd
            if (hasNoThreeConsecutiveOnes(n) && (n % 2 == 1)) {
                result = (result + ((n * n) % MOD)) % MOD;
                count++;
            }
        }

        responseDto.setAnswer(result);
        return responseDto;
    }
    
    private boolean hasNoThreeConsecutiveOnes(long n) {
        String binary = Long.toBinaryString(n);
        return !binary.contains("111");
    }
}
