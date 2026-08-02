package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ205 {

    public ResponseDto Question205() {
        ResponseDto responseDto = new ResponseDto();

        // Problem 205: Dice probability
        // Peter: 9 four-sided dice (1-4)
        // Colin: 6 six-sided dice (1-6)
        // Find probability that Peter's total > Colin's total

        int peterDice = 9;
        int peterSides = 4;
        int colinDice = 6;
        int colinSides = 6;

        // Maximum and minimum possible sums
        int peterMax = peterDice * peterSides; // 36
        int peterMin = peterDice; // 9
        int colinMax = colinDice * colinSides; // 36
        int colinMin = colinDice; // 6

        // Array to store count of ways to achieve each sum
        long[] peterWays = new long[peterMax + 1];
        long[] colinWays = new long[colinMax + 1];

        // Calculate distribution for Peter's dice
        calculateDistribution(peterWays, peterDice, peterSides);

        // Calculate distribution for Colin's dice
        calculateDistribution(colinWays, colinDice, colinSides);

        // Count winning scenarios for Peter
        long peterWins = 0;
        long totalOutcomes = 0;

        for (int pSum = peterMin; pSum <= peterMax; pSum++) {
            for (int cSum = colinMin; cSum <= colinMax; cSum++) {
                long outcomes = peterWays[pSum] * colinWays[cSum];
                totalOutcomes += outcomes;

                if (pSum > cSum) {
                    peterWins += outcomes;
                }
            }
        }

        double probability = (double) peterWins / totalOutcomes;

        String result = String.format("%.7f", probability);

        responseDto.setAnswer(result);
        return responseDto;
    }

    private void calculateDistribution(long[] ways, int numDice, int numSides) {
        // Base case: 1 die can produce 1 to numSides with equal probability
        long[] current = new long[numSides * numDice + 1];
        for (int i = 1; i <= numSides; i++) {
            current[i] = 1;
        }

        // For each additional die, convolve with the distribution
        for (int die = 2; die <= numDice; die++) {
            long[] next = new long[numSides * die + 1];
            for (int sum = die; sum <= numSides * die; sum++) {
                for (int face = 1; face <= numSides; face++) {
                    if (sum - face >= die - 1) {
                        next[sum] += current[sum - face];
                    }
                }
            }
            current = next;
        }

        System.arraycopy(current, 0, ways, 0, Math.min(current.length, ways.length));
    }
}
