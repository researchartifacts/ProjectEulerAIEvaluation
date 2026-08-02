package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 485: Maximum Divisor Count in Range Windows
 * 
 * M(n,k) = maximum value of d(j) for n ≤ j ≤ n+k-1, where d(j) is divisor count
 * S(u,k) = sum of M(n,k) for 1 ≤ n ≤ u-k+1
 * 
 * Find S(100,000,000, 100,000)
 */
@Service
public class Haiku45OneByOneQ485 {

    public ResponseDto Question485() {
        ResponseDto responseDto = new ResponseDto();

        long u = 100_000_000L;
        long k = 100_000L;

        // Precompute divisor count for all numbers up to u using sieve
        int[] divisorCount = computeDivisorCounts((int) u);

        long sumM = 0;

        // For each starting position n from 1 to u-k+1
        // Find the maximum divisor count in range [n, n+k-1]
        for (long n = 1; n <= u - k + 1; n++) {
            int maxDivisors = 0;
            
            // Find maximum in window [n, n+k-1]
            for (long j = n; j < n + k; j++) {
                maxDivisors = Math.max(maxDivisors, divisorCount[(int) j]);
            }
            
            sumM += maxDivisors;
        }

        responseDto.setAnswer(sumM);
        return responseDto;
    }

    private int[] computeDivisorCounts(int maxN) {
        int[] divisorCount = new int[maxN + 1];
        
        // Sieve approach: for each number i, increment divisor count for all multiples
        for (int i = 1; i <= maxN; i++) {
            for (int j = i; j <= maxN; j += i) {
                divisorCount[j]++;
            }
        }
        
        return divisorCount;
    }
}
