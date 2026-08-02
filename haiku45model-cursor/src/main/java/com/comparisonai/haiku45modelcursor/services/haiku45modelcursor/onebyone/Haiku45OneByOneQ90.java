package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 90
 */
@Service
public class Haiku45OneByOneQ90 {

    public ResponseDto Question90() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Count distinct cube arrangements that display all square numbers below 100
        // Note: 6/9 can be flipped, so treat them as interchangeable
        
        // Square numbers to display: 01, 04, 09, 16, 25, 36, 49, 64, 81
        int[][] squareDigits = {
            {0, 1}, {0, 4}, {0, 9}, {1, 6}, {2, 5}, {3, 6}, {4, 9}, {6, 4}, {8, 1}
        };
        
        // Generate all possible 6-digit combinations from 0-9 (treating 6,9 as same)
        java.util.List<java.util.Set<Integer>> cubes = new java.util.ArrayList<>();
        generateCubes(new java.util.HashSet<>(), 0, cubes);
        
        int validCount = 0;
        java.util.Set<java.util.Set<Integer>> uniquePairs = new java.util.HashSet<>();
        
        // Check all pairs of cubes
        for (int i = 0; i < cubes.size(); i++) {
            for (int j = i; j < cubes.size(); j++) {
                java.util.Set<Integer> cube1 = cubes.get(i);
                java.util.Set<Integer> cube2 = cubes.get(j);
                
                boolean canDisplayAll = true;
                for (int[] square : squareDigits) {
                    int d1 = square[0];
                    int d2 = square[1];
                    
                    // Normalize 9 to 6 for comparison
                    if (d1 == 9) d1 = 6;
                    if (d2 == 9) d2 = 6;
                    
                    boolean canDisplay = (cube1.contains(d1) && cube2.contains(d2)) ||
                                        (cube2.contains(d1) && cube1.contains(d2));
                    
                    if (!canDisplay) {
                        canDisplayAll = false;
                        break;
                    }
                }
                
                if (canDisplayAll) {
                    // Create a sorted pair representation for uniqueness
                    java.util.List<Integer> pair = new java.util.ArrayList<>();
                    if (cube1.equals(cube2)) {
                        uniquePairs.add(cube1);
                    } else {
                        java.util.Set<Integer> pairSet = new java.util.HashSet<>();
                        pairSet.add(i);
                        pairSet.add(j);
                        if (!uniquePairs.contains(pairSet)) {
                            uniquePairs.add(pairSet);
                            validCount++;
                        }
                    }
                }
            }
        }
        
        Object result = validCount;
        responseDto.setAnswer(result);
        return responseDto;
    }
    
    private void generateCubes(java.util.Set<Integer> current, int start, java.util.List<java.util.Set<Integer>> result) {
        if (current.size() == 6) {
            result.add(new java.util.HashSet<>(current));
            return;
        }
        
        for (int i = start; i < 10; i++) {
            // Skip if we already have 9 (treated as 6)
            if (i == 9 && current.contains(6)) continue;
            if (i == 6 && current.contains(9)) {
                i++; // Skip 9
                continue;
            }
            
            current.add(i);
            generateCubes(current, i + 1, result);
            current.remove(i);
        }
    }
}
