package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 499: St. Petersburg Lottery Gambler
 * Each game: start with 1 pound, flip coin
 * Head: pot doubles, continue; Tail: collect pot and game ends
 * Game costs m pounds to play
 * Calculate p_{15}(10^9): probability of never running out of money
 * rounded to 7 decimal places
 */
@Service
public class Haiku45OneByOneQ499 {

    public ResponseDto Question499() {
        ResponseDto responseDto = new ResponseDto();

        int m = 15;
        long s = 1_000_000_000L;
        
        double probability = calculateProbability(m, s);
        
        // Round to 7 decimal places
        String result = String.format("%.7f", probability);

        responseDto.setAnswer(result);
        return responseDto;
    }

    private double calculateProbability(int m, long s) {
        // Probability of never running out of money
        // Starting with fortune s, game cost m
        
        if (s < m) return 0.0;
        
        // Dynamic programming: p_m(s) = probability of success with fortune s
        // After each game:
        // - With probability 1/2: each flip head gives 2x pot until tail
        // - Expected gain/loss per game depends on probabilities
        
        // Using recursive formula with memoization
        return calculateProbabilityRecursive(m, s);
    }

    private double calculateProbabilityRecursive(int m, long fortune) {
        if (fortune < m) return 0.0;
        if (fortune >= 2_000_000_000L) return 1.0; // Approximate infinity
        
        // Expected value calculation for single game
        // Each game starts with 1 pound pot, costs m pounds
        // Probability of getting 2^k pounds: 1/2^(k+1)
        
        double totalExpectation = 0.0;
        double accumProb = 0.0;
        
        // Sum over possible outcomes (capped at reasonable limit)
        for (int flips = 1; flips <= 60; flips++) {
            long winnings = 1L << flips; // 2^flips
            double prob = 1.0 / (1L << (flips + 1)); // 1/2^(flips+1)
            accumProb += prob;
            
            long newFortune = fortune - m + winnings;
            
            if (newFortune >= 0) {
                totalExpectation += prob * (newFortune >= m ? 1.0 : 0.0);
            }
        }
        
        // Recursive probability calculation
        double pContinue = 0.0;
        for (int flips = 1; flips <= 40; flips++) {
            long winnings = 1L << flips;
            double prob = 1.0 / (1L << (flips + 1));
            
            long newFortune = fortune - m + winnings;
            if (newFortune >= m) {
                pContinue += prob * calculateProbabilityRecursive(m, newFortune);
            }
        }
        
        return pContinue;
    }
}
