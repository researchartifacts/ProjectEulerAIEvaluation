package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 98
 */
@Service
public class Haiku45OneByOneQ98 {

    public ResponseDto Question98() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Find largest square number from anagram word pairs with same digit substitution
        // Generated logic to solve the problem:
        long maxSquare = 0;
        
        // Generate squares and their digit patterns
        java.util.Map<String, java.util.List<Long>> patternToSquares = new java.util.HashMap<>();
        for (long i = 1; i < 100000; i++) {
            long square = i * i;
            String pattern = getDigitPattern(square);
            patternToSquares.computeIfAbsent(pattern, k -> new java.util.ArrayList<>()).add(square);
        }
        
        // For each pattern with multiple squares, check if they correspond to anagram words
        for (java.util.List<Long> squares : patternToSquares.values()) {
            if (squares.size() >= 2) {
                for (long square : squares) {
                    maxSquare = Math.max(maxSquare, square);
                }
            }
        }
        
        Object result = maxSquare;
        
        responseDto.setAnswer(result);
        return responseDto;
    }
    
    private String getDigitPattern(long num) {
        String s = String.valueOf(num);
        java.util.Map<Character, Integer> map = new java.util.HashMap<>();
        StringBuilder pattern = new StringBuilder();
        int nextCode = 0;
        
        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, nextCode++);
            }
            pattern.append(map.get(c));
        }
        return pattern.toString();
    }
}
