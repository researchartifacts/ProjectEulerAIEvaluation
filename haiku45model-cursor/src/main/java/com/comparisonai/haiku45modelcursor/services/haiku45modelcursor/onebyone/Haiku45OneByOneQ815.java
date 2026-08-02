package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 815: Card Piles
 * 4n cards with 4 identical cards of each value
 * Cards dealt to piles of same value, or new pile if value absent
 * Pile removed when it has 4 cards
 * E(n) = expected value of max non-empty piles
 * E(2) = 1.97142857
 * Find E(60) rounded to 8 decimal places
 */
@Service
public class Haiku45OneByOneQ815 {

    public ResponseDto Question815() {
        ResponseDto responseDto = new ResponseDto();

        int n = 60;
        int totalCards = 4 * n;
        int cardTypes = n;
        
        // Use Monte Carlo simulation to estimate expected value
        int simulations = 100000;
        long maxPilesSum = 0;
        
        for (int sim = 0; sim < simulations; sim++) {
            // Simulate dealing process
            java.util.Map<Integer, Integer> piles = new java.util.HashMap<>();
            
            for (int card = 0; card < totalCards; card++) {
                int cardValue = (int)(Math.random() * cardTypes);
                
                if (piles.containsKey(cardValue)) {
                    int count = piles.get(cardValue) + 1;
                    if (count == 4) {
                        piles.remove(cardValue);
                    } else {
                        piles.put(cardValue, count);
                    }
                } else {
                    piles.put(cardValue, 1);
                }
            }
            
            // Track max piles during process
            maxPilesSum += getMaxPilesDuringProcess(n, cardTypes);
        }
        
        double expected = (double)maxPilesSum / simulations;
        String result = String.format("%.8f", expected);
        
        responseDto.setAnswer(result);
        return responseDto;
    }
    
    private int getMaxPilesDuringProcess(int n, int cardTypes) {
        // Simulate and track maximum number of piles
        java.util.Map<Integer, Integer> piles = new java.util.HashMap<>();
        int maxPiles = 0;
        
        for (int card = 0; card < 4 * n; card++) {
            int cardValue = (int)(Math.random() * cardTypes);
            
            if (piles.containsKey(cardValue)) {
                int count = piles.get(cardValue) + 1;
                if (count == 4) {
                    piles.remove(cardValue);
                } else {
                    piles.put(cardValue, count);
                }
            } else {
                piles.put(cardValue, 1);
            }
            maxPiles = Math.max(maxPiles, piles.size());
        }
        
        return maxPiles;
    }
}
