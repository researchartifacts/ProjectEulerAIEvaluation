package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;

/**
 * Problem 470: Super Ramvok Game Theory
 * Ramvok: Player chooses turns t, pays ct upfront, rolls die up to t times
 * Can stop to take current roll or continue (last roll must be taken)
 * Super Ramvok: Game repeats with die face alterations until all faces blank
 * S(d, c) = expected profit for optimal Super Ramvok strategy
 * F(n) = sum of S(d,c) for 4≤d≤n, 0≤c≤n
 * Calculate F(20) rounded to nearest integer
 */
@Service
public class Haiku45OneByOneQ470 {

    public ResponseDto Question470() {
        ResponseDto responseDto = new ResponseDto();

        int n = 20;
        double totalProfit = 0.0;
        
        // F(n) = sum_{d=4}^{n} sum_{c=0}^{n} S(d, c)
        
        for (int d = 4; d <= n; d++) {
            for (int c = 0; c <= n; c++) {
                double profit = computeSuperRamvok(d, c);
                totalProfit += profit;
            }
        }
        
        // Round to nearest integer
        long result = Math.round(totalProfit);
        
        responseDto.setAnswer(result);
        return responseDto;
    }
    
    private double computeSuperRamvok(int d, int c) {
        // S(d, c) = expected profit from Super Ramvok with d-sided die and cost c
        
        // First, compute expected profit from single Ramvok game R(d, c)
        double singleGameProfit = computeRamvok(d, c);
        
        // In Super Ramvok, game repeats with die face alterations
        // Each iteration has one face flipped
        // Game continues until all d faces are blank
        
        double totalProfit = 0.0;
        double currentStateProfit = singleGameProfit;
        
        // Expected number of iterations before all faces are blank
        // is related to the coupon collector problem
        
        for (int facesBlank = 0; facesBlank < d; facesBlank++) {
            // Probability of reaching this state
            double probReachState = 1.0 / (d - facesBlank);
            totalProfit += currentStateProfit * probReachState;
            
            // Update for next iteration (fewer faces available)
            int activeFaces = d - facesBlank - 1;
            if (activeFaces > 0) {
                currentStateProfit = computeRamvok(activeFaces, c);
            }
        }
        
        return totalProfit;
    }
    
    private double computeRamvok(int d, int c) {
        // R(d, c) = expected profit from single Ramvok game
        // Player chooses turns t, pays ct upfront, rolls die up to t times
        
        // Optimal strategy: maximize E[roll value] - ct
        // E[roll value] increases with t (more chances to get higher)
        // But cost ct increases linearly
        
        double maxProfit = 0.0;
        
        // Try different values of t
        for (int t = 0; t <= Math.min(d + 10, 50); t++) {
            double upfrontCost = c * t;
            double expectedValue = expectedRollValue(d, t);
            double profit = expectedValue - upfrontCost;
            
            maxProfit = Math.max(maxProfit, profit);
        }
        
        // Also consider t = infinity (if c = 0)
        if (c == 0) {
            double infinityProfit = (d + 1) / 2.0; // Expected value of continuous rolling
            maxProfit = Math.max(maxProfit, infinityProfit);
        }
        
        return maxProfit;
    }
    
    private double expectedRollValue(int d, int t) {
        // Expected value of a d-sided die after optimal play with t turns
        
        if (t == 0) return 0.0;
        if (t == 1) return (d + 1) / 2.0; // Just take the first roll
        
        // For t > 1, can stop at any point or continue
        // Optimal strategy: keep rolling if current < threshold
        
        // Dynamic programming backward induction
        double[] expectedValues = new double[t + 1];
        expectedValues[t] = (d + 1) / 2.0; // Must accept at turn t
        
        for (int turn = t - 1; turn >= 1; turn--) {
            double threshold = expectedValues[turn + 1];
            double expected = 0.0;
            
            // For each possible roll
            for (int roll = 1; roll <= d; roll++) {
                if (roll >= threshold) {
                    expected += roll / (double) d;
                } else {
                    expected += expectedValues[turn + 1] / (double) d;
                }
            }
            
            expectedValues[turn] = expected;
        }
        
        return expectedValues[1];
    }
}
