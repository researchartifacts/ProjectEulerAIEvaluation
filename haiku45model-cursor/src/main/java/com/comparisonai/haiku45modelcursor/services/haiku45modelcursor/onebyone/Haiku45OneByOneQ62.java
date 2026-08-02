package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 62
 */
@Service
public class Haiku45OneByOneQ62 {

    public ResponseDto Question62() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: The cube, 41063625 (345^3), can be permuted to produce two other cubes: 56623...
        // Generated logic to solve the problem:
        
        java.util.Map<String, java.util.List<Long>> sortedDigitsMap = new java.util.HashMap<>();
        
        // Generate cubes and find permutations
        long result = 0;
        for (long n = 1; n < 10000; n++) {
            long cube = n * n * n;
            String sorted = sortDigits(cube);
            
            if (!sortedDigitsMap.containsKey(sorted)) {
                sortedDigitsMap.put(sorted, new java.util.ArrayList<>());
            }
            sortedDigitsMap.get(sorted).add(cube);
            
            // Check if we found exactly 5 cubes with same digit permutation
            if (sortedDigitsMap.get(sorted).size() == 5) {
                result = sortedDigitsMap.get(sorted).get(0);
                break;
            }
        }
        
        responseDto.setAnswer(result);
        return responseDto;
    }
    
    private String sortDigits(long num) {
        char[] digits = String.valueOf(num).toCharArray();
        java.util.Arrays.sort(digits);
        return new String(digits);
    }
}
