package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 61
 */
@Service
public class Haiku45OneByOneQ61 {

    public ResponseDto Question61() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Find the sum of cyclic figurate numbers (triangle, square, pentagonal, hexagonal, heptagonal, octagonal)
        // Generated logic to solve the problem:
        
        // Generate 4-digit figurate numbers for all 6 types
        java.util.List<Integer> triangle = new java.util.ArrayList<>();
        java.util.List<Integer> square = new java.util.ArrayList<>();
        java.util.List<Integer> pentagonal = new java.util.ArrayList<>();
        java.util.List<Integer> hexagonal = new java.util.ArrayList<>();
        java.util.List<Integer> heptagonal = new java.util.ArrayList<>();
        java.util.List<Integer> octagonal = new java.util.ArrayList<>();
        
        // Triangle: n(n+1)/2
        for (int n = 1; ; n++) {
            long val = (long)n * (n + 1) / 2;
            if (val > 9999) break;
            if (val >= 1000) triangle.add((int)val);
        }
        
        // Square: n^2
        for (int n = 1; ; n++) {
            long val = (long)n * n;
            if (val > 9999) break;
            if (val >= 1000) square.add((int)val);
        }
        
        // Pentagonal: n(3n-1)/2
        for (int n = 1; ; n++) {
            long val = (long)n * (3 * n - 1) / 2;
            if (val > 9999) break;
            if (val >= 1000) pentagonal.add((int)val);
        }
        
        // Hexagonal: n(2n-1)
        for (int n = 1; ; n++) {
            long val = (long)n * (2 * n - 1);
            if (val > 9999) break;
            if (val >= 1000) hexagonal.add((int)val);
        }
        
        // Heptagonal: n(5n-3)/2
        for (int n = 1; ; n++) {
            long val = (long)n * (5 * n - 3) / 2;
            if (val > 9999) break;
            if (val >= 1000) heptagonal.add((int)val);
        }
        
        // Octagonal: n(3n-2)
        for (int n = 1; ; n++) {
            long val = (long)n * (3 * n - 2);
            if (val > 9999) break;
            if (val >= 1000) octagonal.add((int)val);
        }
        
        // Helper method to get last 2 digits and first 2 digits
        java.util.Map<Integer, java.util.List<Integer>> figurateMap = new java.util.HashMap<>();
        figurateMap.put(3, triangle);
        figurateMap.put(4, square);
        figurateMap.put(5, pentagonal);
        figurateMap.put(6, hexagonal);
        figurateMap.put(7, heptagonal);
        figurateMap.put(8, octagonal);
        
        // Find cyclic chain of 6 numbers
        long result = 0;
        for (int start : triangle) {
            java.util.Set<Integer> used = new java.util.HashSet<>();
            java.util.List<Integer> chain = new java.util.ArrayList<>();
            if (findCyclicChain(start, figurateMap, used, chain, 0)) {
                for (int num : chain) result += num;
                break;
            }
        }
        
        responseDto.setAnswer(result);
        return responseDto;
    }
    
    private boolean findCyclicChain(int num, java.util.Map<Integer, java.util.List<Integer>> figurateMap, 
                                     java.util.Set<Integer> used, java.util.List<Integer> chain, int typeUsed) {
        if (chain.size() == 6) {
            int lastLast2 = chain.get(5) % 100;
            int firstFirst2 = chain.get(0) / 100;
            return lastLast2 == firstFirst2;
        }
        
        int last2 = num % 100;
        
        for (int type = 3; type <= 8; type++) {
            if ((typeUsed & (1 << type)) != 0) continue;
            
            for (int cand : figurateMap.get(type)) {
                if (cand / 100 == last2 && !used.contains(cand)) {
                    chain.add(cand);
                    used.add(cand);
                    if (findCyclicChain(cand, figurateMap, used, chain, typeUsed | (1 << type))) {
                        return true;
                    }
                    chain.remove(chain.size() - 1);
                    used.remove(cand);
                }
            }
        }
        return false;
    }
}
