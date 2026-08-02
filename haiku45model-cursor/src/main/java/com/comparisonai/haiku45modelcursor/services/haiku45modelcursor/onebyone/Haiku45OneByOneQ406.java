package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 406: Guessing game strategy - worst case cost
 * Find sum of C(10^12, sqrt(k), sqrt(F_k)) for k=1 to 30
 */
@Service
public class Haiku45OneByOneQ406 {

    public ResponseDto Question406() {
        ResponseDto responseDto = new ResponseDto();

        // C(n, a, b) = worst-case cost of optimal guessing strategy
        // When finding hidden number in {1..n} with asymmetric costs
        // a = cost of "too low", b = cost of "too high"
        
        // Generate Fibonacci numbers
        java.util.List<Long> fibs = new java.util.ArrayList<>();
        long f1 = 1, f2 = 1;
        fibs.add(f1);
        fibs.add(f2);
        for (int i = 2; i < 30; i++) {
            long next = f1 + f2;
            fibs.add(next);
            f1 = f2;
            f2 = next;
        }

        double totalCost = 0.0;
        long n = 1000000000000L; // 10^12

        for (int k = 1; k <= 30; k++) {
            double sqrtK = Math.sqrt(k);
            double sqrtFk = Math.sqrt(fibs.get(k - 1));
            
            // Compute C(n, a, b) = worst-case cost with optimal strategy
            double cost = computeOptimalCost(n, sqrtK, sqrtFk);
            totalCost += cost;
        }

        // Round to 8 decimal places
        double result = Math.round(totalCost * 100000000.0) / 100000000.0;

        Object answer = result;
        responseDto.setAnswer(answer);
        return responseDto;
    }

    private double computeOptimalCost(long n, double a, double b) {
        // Use optimal strategy: weighted binary search
        // Split point chosen to balance costs on left and right
        
        // Optimal worst case: first guess at position that minimizes max(leftCost, rightCost)
        // For n items with costs a (too low) and b (too high):
        // Optimal split: a * left_subtree + b * right_subtree should be balanced
        
        if (n <= 1) return 0;
        if (n == 2) return Math.min(a, b);

        // Dynamic programming approach for cost computation
        double[] dp = new double[(int) Math.min(n + 1, 100000)];
        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i < Math.min(n, 100000); i++) {
            // Try each possible first guess
            double minCost = Double.MAX_VALUE;
            
            for (int guess = 1; guess <= i; guess++) {
                // Left subtree: 1 to guess-1 (guess is correct with cost 0)
                // Right subtree: guess+1 to i
                double leftItems = guess - 1;
                double rightItems = i - guess;
                
                // Worst case cost if we guess at position 'guess'
                double leftCost = (leftItems > 0) ? a + dp[(int)Math.min(leftItems, 99999)] : 0;
                double rightCost = (rightItems > 0) ? b + dp[(int)Math.min(rightItems, 99999)] : 0;
                double worstCase = Math.max(leftCost, rightCost);
                
                minCost = Math.min(minCost, worstCase);
            }
            
            dp[i] = minCost;
        }

        // For large n, use approximation formula
        // C(n, a, b) ≈ log_r(n) * average_cost where r depends on a,b ratio
        if (n >= 100000) {
            double ratio = b / a;
            double rValue = (1.0 + ratio) / 2.0; // Geometric mean-like ratio
            double approxCost = Math.log(n) / Math.log(rValue) * (a + b) / 2.0;
            return approxCost;
        }

        return dp[(int) Math.min(n, 99999)];
    }
}
