package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;

/**
 * Problem 479: Phigital Word Indexing
 * Find W(P(legionary) + P(calorimeters) - P(annihilate) + P(orchestrated) - P(fluttering))
 */
@Service
public class Haiku45OneByOneQ479 {

    private static final String PHRASE = "thereisasyetinsufficientdataforameaningfulanswer";

    public ResponseDto Question479() {
        ResponseDto responseDto = new ResponseDto();

        // Calculate P(word) for each word
        long pLegionary = calculatePosition("legionary");
        long pCalorimeters = calculatePosition("calorimeters");
        long pAnnihilate = calculatePosition("annihilate");
        long pOrchestrated = calculatePosition("orchestrated");
        long pFluttering = calculatePosition("fluttering");

        long resultPosition = pLegionary + pCalorimeters - pAnnihilate + pOrchestrated - pFluttering;

        String result = getWordAtPosition(resultPosition);
        responseDto.setAnswer(result);
        return responseDto;
    }

    private long calculatePosition(String word) {
        // Count how many words come before this word in lexicographic order
        // All words with 15 letters or less from PHRASE characters
        
        char[] available = getAvailableCharacters();
        char[] wordChars = word.toCharArray();
        
        long position = 0;
        
        // Count all words shorter than this word
        for (int len = 1; len < wordChars.length; len++) {
            position += countWordsOfLength(available, len);
        }
        
        // Count words of same length that come before
        position += countWordsBeforeInLength(available, word);
        
        return position + 1; // 1-indexed
    }

    private long countWordsOfLength(char[] available, int len) {
        // Count all possible words of given length using available characters
        Map<Character, Integer> charCount = getCharacterFrequencies();
        return countWordsHelper(charCount, len);
    }

    private long countWordsBeforeInLength(char[] available, String word) {
        // Count words of same length that come lexicographically before
        Map<Character, Integer> charCount = getCharacterFrequencies();
        long count = 0;
        
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            
            // For each character before c, count words we can form
            for (char ch = 'a'; ch < c; ch++) {
                if (charCount.getOrDefault(ch, 0) > 0) {
                    Map<Character, Integer> temp = new HashMap<>(charCount);
                    temp.put(ch, temp.get(ch) - 1);
                    count += countWordsHelper(temp, word.length() - i - 1);
                }
            }
            
            // Use character c
            if (charCount.getOrDefault(c, 0) > 0) {
                charCount.put(c, charCount.get(c) - 1);
            } else {
                return count; // Invalid word
            }
        }
        
        return count;
    }

    private long countWordsHelper(Map<Character, Integer> charCount, int remaining) {
        // Use multinomial coefficient to count arrangements
        long total = 1;
        int sum = remaining;
        
        for (int freq : charCount.values()) {
            for (int i = 0; i < freq && i < remaining; i++) {
                total *= (sum - i);
                total /= (i + 1);
            }
        }
        
        return Math.min(total, Long.MAX_VALUE);
    }

    private String getWordAtPosition(long position) {
        // Reverse operation: given position, find word
        char[] available = getAvailableCharacters();
        Map<Character, Integer> charCount = getCharacterFrequencies();
        
        StringBuilder result = new StringBuilder();
        long currentPos = position;
        int maxLen = 15;
        
        // Determine length
        int wordLen = 1;
        long count = 0;
        for (int len = 1; len <= maxLen; len++) {
            long wordsOfLen = countWordsOfLength(available, len);
            if (count + wordsOfLen >= currentPos) {
                wordLen = len;
                currentPos -= count;
                break;
            }
            count += wordsOfLen;
        }
        
        // Build word character by character
        Map<Character, Integer> remaining = new HashMap<>(charCount);
        for (int i = 0; i < wordLen; i++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (remaining.getOrDefault(ch, 0) > 0) {
                    remaining.put(ch, remaining.get(ch) - 1);
                    long wordsWithCh = countWordsHelper(remaining, wordLen - i - 1);
                    
                    if (currentPos <= wordsWithCh) {
                        result.append(ch);
                        break;
                    }
                    
                    currentPos -= wordsWithCh;
                    remaining.put(ch, remaining.get(ch) + 1);
                }
            }
        }
        
        return result.toString();
    }

    private char[] getAvailableCharacters() {
        return PHRASE.toCharArray();
    }

    private Map<Character, Integer> getCharacterFrequencies() {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : PHRASE.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        return freq;
    }
}
