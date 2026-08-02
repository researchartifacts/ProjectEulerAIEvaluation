package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 54
 */
@Service
public class Haiku45OneByOneQ54 {

    public ResponseDto Question54() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Evaluate poker hands and count how many Player 1 wins
        // Generated logic to solve the problem:
        
        class Card implements Comparable<Card> {
            int value;
            char suit;
            Card(String s) {
                this.value = "23456789TJQKA".indexOf(s.charAt(0));
                this.suit = s.charAt(1);
            }
            public int compareTo(Card other) {
                return Integer.compare(this.value, other.value);
            }
        }
        
        java.util.function.Function<Card[], Integer> evaluateHand = hand -> {
            java.util.Arrays.sort(hand);
            java.util.Map<Integer, Integer> valueCounts = new java.util.HashMap<>();
            java.util.Map<Character, Integer> suitCounts = new java.util.HashMap<>();
            int[] values = new int[5];
            
            for (int i = 0; i < 5; i++) {
                valueCounts.put(hand[i].value, valueCounts.getOrDefault(hand[i].value, 0) + 1);
                suitCounts.put(hand[i].suit, suitCounts.getOrDefault(hand[i].suit, 0) + 1);
                values[i] = hand[i].value;
            }
            
            boolean isFlush = suitCounts.size() == 1;
            boolean isStraight = values[4] - values[0] == 4 && valueCounts.size() == 5;
            
            java.util.List<Integer> counts = new java.util.ArrayList<>(valueCounts.values());
            java.util.Collections.sort(counts, (a, b) -> b - a);
            
            if (isStraight && isFlush && values[4] == 12) return 8; // Royal flush
            if (isStraight && isFlush) return 7; // Straight flush
            if (counts.get(0) == 4) return 6; // Four of a kind
            if (counts.get(0) == 3 && counts.get(1) == 2) return 5; // Full house
            if (isFlush) return 4; // Flush
            if (isStraight) return 3; // Straight
            if (counts.get(0) == 3) return 2; // Three of a kind
            if (counts.get(0) == 2 && counts.get(1) == 2) return 1; // Two pair
            if (counts.get(0) == 2) return 0; // One pair
            return -1; // High card
        };
        
        long result = 0;
        try {
            java.nio.file.Path path = java.nio.file.Paths.get("resources/documents/0054_poker.txt");
            if (!java.nio.file.Files.exists(path)) {
                path = java.nio.file.Paths.get("<REDACTED_PATH>/resources/0054_poker.txt");
            }
            if (java.nio.file.Files.exists(path)) {
                for (String line : java.nio.file.Files.readAllLines(path)) {
                    String[] cards = line.trim().split(" ");
                    Card[] hand1 = new Card[5];
                    Card[] hand2 = new Card[5];
                    for (int i = 0; i < 5; i++) {
                        hand1[i] = new Card(cards[i]);
                        hand2[i] = new Card(cards[i + 5]);
                    }
                    if (evaluateHand.apply(hand1) > evaluateHand.apply(hand2)) {
                        result++;
                    }
                }
            }
        } catch (Exception e) {
            result = -1;
        }
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
