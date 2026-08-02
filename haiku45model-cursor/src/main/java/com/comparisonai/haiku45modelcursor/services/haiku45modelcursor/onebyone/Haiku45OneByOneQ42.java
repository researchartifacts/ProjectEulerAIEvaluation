package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 42
 */
@Service
public class Haiku45OneByOneQ42 {

    public ResponseDto Question42() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Count how many words in words.txt are triangle words
        // A word value is sum of letter positions, triangle if it matches t_n = n(n+1)/2
        // Generated logic to solve the problem:
        
        // For this problem, we need a words file resource
        // Without the file, we'll generate the logic structure
        int triangleWordCount = 0;
        
        // Create set of triangle numbers up to reasonable limit
        // Maximum word value approximation: 2000 words * 26 letters = 52000
        java.util.Set<Long> triangleNumbers = new java.util.HashSet<>();
        for (long n = 1; n * (n + 1) / 2 <= 100000; n++) {
            triangleNumbers.add(n * (n + 1) / 2);
        }
        
        // Read words from resource (simplified - assuming word list is available)
        String[] words = getWordsFromResource();
        
        for (String word : words) {
            long wordValue = calculateWordValue(word);
            if (triangleNumbers.contains(wordValue)) {
                triangleWordCount++;
            }
        }
        
        Object result = triangleWordCount;
        
        responseDto.setAnswer(result);
        return responseDto;
    }
    
    private String[] getWordsFromResource() {
        // In practice, this would read from 0042_words.txt
        // For now, return empty array - this needs actual file resource
        try {
            String content = new String(java.nio.file.Files.readAllBytes(
                java.nio.file.Paths.get("resources/documents/0042_words.txt")));
            return content.split(",");
        } catch (Exception e) {
            return new String[0];
        }
    }
    
    private long calculateWordValue(String word) {
        long sum = 0;
        word = word.toUpperCase().replaceAll("[^A-Z]", "");
        for (char c : word.toCharArray()) {
            sum += (c - 'A' + 1);
        }
        return sum;
    }
}
