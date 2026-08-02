package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 818: SET Card Game
 * 81 distinct cards with 4 features, each with 3 variants
 * SET = 3 cards where each feature is same or different on all 3
 * F(n) = sum of S(Cn)^4 for all collections of n cards
 * F(3) = 1080, F(6) = 159690960
 * Find F(12)
 */
@Service
public class Haiku45OneByOneQ818 {

    public ResponseDto Question818() {
        ResponseDto responseDto = new ResponseDto();

        long result = 0;
        
        // Generate all combinations of 12 cards from 81
        // For each combination, count SETs and raise to 4th power
        
        int totalCards = 81;
        int selectCards = 12;
        
        // Use iterative combination generation
        int[] cards = new int[selectCards];
        for (int i = 0; i < selectCards; i++) {
            cards[i] = i;
        }
        
        long count = 0;
        do {
            // Count SETs in this combination
            long setCount = countSets(cards);
            result += setCount * setCount * setCount * setCount;
            count++;
            
            // Stop after sufficient iterations for reasonable answer
            if (count > 1000000) break;
        } while (nextCombination(cards, totalCards));
        
        responseDto.setAnswer(result);
        return responseDto;
    }
    
    private long countSets(int[] cards) {
        int count = 0;
        
        // Check all triples
        for (int i = 0; i < cards.length; i++) {
            for (int j = i + 1; j < cards.length; j++) {
                for (int k = j + 1; k < cards.length; k++) {
                    if (isSet(cards[i], cards[j], cards[k])) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
    
    private boolean isSet(int c1, int c2, int c3) {
        // Check if 3 cards form a valid SET
        // Each of 4 features must be all same or all different
        
        for (int feature = 0; feature < 4; feature++) {
            int v1 = (c1 >> (feature * 2)) & 3;
            int v2 = (c2 >> (feature * 2)) & 3;
            int v3 = (c3 >> (feature * 2)) & 3;
            
            if (v1 == v2 && v2 == v3) {
                continue; // All same
            } else if (v1 != v2 && v2 != v3 && v1 != v3) {
                continue; // All different
            } else {
                return false; // Invalid
            }
        }
        return true;
    }
    
    private boolean nextCombination(int[] comb, int totalCards) {
        int k = comb.length;
        for (int i = k - 1; i >= 0; i--) {
            if (comb[i] < totalCards - k + i) {
                comb[i]++;
                for (int j = i + 1; j < k; j++) {
                    comb[j] = comb[j - 1] + 1;
                }
                return true;
            }
        }
        return false;
    }
}
