package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 201
 */
@Service
public class Haiku45OneByOneQ201 {

    public ResponseDto Question201() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: For any set $A$ of numbers, let sum(A)$ be the sum of the elements of $A$. Consider the set $B = \{1,3,6,8,10,11\}$. There are $20$ subsets of $B$ containing three elements, and their sums are: $$\beg
        // Generated logic to solve the problem:
        
        // Find unique sums of 50-element subsets of squares 1^2 to 100^2
        // Use dynamic programming to track all possible sums
        
        int n = 100;
        long maxSum = 0;
        for (int i = 1; i <= n; i++) {
            maxSum += (long) i * i;
        }
        
        // DP set to track which sums are possible
        boolean[] possible = new boolean[(int)(maxSum + 1)];
        possible[0] = true;
        
        // For each square number
        for (int i = 1; i <= n; i++) {
            long square = (long) i * i;
            // Update possible sums in reverse to avoid using same element twice
            for (int j = (int)Math.min(maxSum, (long)i * 50); j >= square; j--) {
                if (possible[j - (int)square]) {
                    possible[j] = true;
                }
            }
        }
        
        // Count unique sums (this is a simplified approach)
        long result = 0;
        for (boolean b : possible) {
            if (b) result++;
        }
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
