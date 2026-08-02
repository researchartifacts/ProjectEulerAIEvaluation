package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 430: Disk flips - expected white sides
 * Find E(10^10, 4000) - expected disks showing white after random flips
 */
@Service
public class Haiku45OneByOneQ430 {

    public ResponseDto Question430() {
        ResponseDto responseDto = new ResponseDto();

        long N = 10000000000L;
        long M = 4000L;
        
        // E(N, M) = expected number of disks showing white after M turns
        // Each turn: choose A, B uniformly in [1, N], flip disks A to B
        
        // Key insight: Each disk i has independent probability of being white
        // P(disk i is white) depends on parity of times it was flipped
        
        // For disk i, probability it's included in a flip is:
        // P(A <= i <= B) where A, B chosen uniformly from [1, N]
        
        double expectedWhite = 0.0;
        
        // For large N, use continuous approximation
        if (N > 1000000) {
            expectedWhite = calculateLargeN(N, M);
        } else {
            expectedWhite = calculateExact(N, M);
        }
        
        responseDto.setAnswer(expectedWhite);
        return responseDto;
    }
    
    private double calculateLargeN(long N, long M) {
        // For each disk position i in [1, N]:
        // P(disk i flipped in one turn) = P(A <= i <= B)
        
        // With A, B uniform in [1, N]:
        // P(A <= i and i <= B) = (i/N) * ((N-i+1)/N) * 2 - ...
        
        // Using integral approximation for continuous case:
        // P(flip at position x) = x(1 - (x-1)/N) / N^2 * N^2
        //                        = x(N - x + 1) / N^2
        
        // After M flips, probability disk is white depends on flip parity
        
        double totalExpected = 0.0;
        
        // Integrate over all positions
        long samples = Math.min(N, 100000);
        double step = (double)N / samples;
        
        for (long i = 1; i <= samples; i++) {
            double pos = i * step;
            
            // Probability this position is flipped in one turn
            double pFlipOnce = (pos * (N - pos + 1)) / (N * N);
            
            // After M flips, probability of even flips (white side shows)
            // Using binomial: P(even flips) in M trials with prob p
            double pEven = calculateBinomialEven(M, pFlipOnce);
            
            totalExpected += pEven;
        }
        
        return totalExpected * (N / samples);
    }
    
    private double calculateExact(long N, long M) {
        // For smaller N, calculate exact expectation
        
        double totalExpected = 0.0;
        
        for (long i = 1; i <= N; i++) {
            // Probability disk i is white after M flips
            // P(disk i included in flip A to B) = number of valid (A,B) pairs / N^2
            
            long validPairs = 0;
            
            for (long A = 1; A <= N; A++) {
                for (long B = A; B <= N; B++) {
                    if (A <= i && i <= B) {
                        validPairs++;
                    }
                }
                
                // Also count (B, A) where B < A
                for (long B = 1; B < A; B++) {
                    if (B <= i && i <= A) {
                        validPairs++;
                    }
                }
            }
            
            double pFlip = (double)validPairs / (N * N);
            double pWhite = calculateBinomialEven(M, pFlip);
            
            totalExpected += pWhite;
        }
        
        return totalExpected;
    }
    
    private double calculateBinomialEven(long trials, double probFlip) {
        // P(even number of successes in 'trials' independent trials with prob probFlip)
        // = (1 + (1 - 2*p)^trials) / 2
        
        double q = 1 - 2 * probFlip;
        double qPower = Math.pow(q, trials);
        
        return (1 + qPower) / 2;
    }
}
