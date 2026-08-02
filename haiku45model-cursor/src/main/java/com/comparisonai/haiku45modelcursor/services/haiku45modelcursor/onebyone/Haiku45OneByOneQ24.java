package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.Arrays;

/**
 * Problem 24
 */
@Service
public class Haiku45OneByOneQ24 {

    public ResponseDto Question24() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Find the millionth lexicographic permutation of digits 0-9
        // Generated logic to solve the problem:
        int[] digits = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int permutationIndex = 1000000;
        
        // Find the permutationIndex-th permutation (1-indexed)
        int[] result = findPermutation(digits, permutationIndex);
        
        // Convert result to number
        StringBuilder sb = new StringBuilder();
        for (int digit : result) {
            sb.append(digit);
        }
        Object answer = Long.parseLong(sb.toString());
        
        responseDto.setAnswer(answer);
        return responseDto;
    }
    
    private int[] findPermutation(int[] digits, int n) {
        int[] result = new int[digits.length];
        int[] available = digits.clone();
        
        // Calculate factorials
        long[] factorial = new long[available.length];
        factorial[0] = 1;
        for (int i = 1; i < factorial.length; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
        
        // n is 1-indexed, convert to 0-indexed
        long index = n - 1;
        
        // Build permutation digit by digit
        for (int i = 0; i < result.length; i++) {
            long fact = (i < factorial.length - 1) ? factorial[available.length - i - 1] : 1;
            int pos = (int) (index / fact);
            
            // Find the pos-th available digit
            int count = 0;
            int selectedDigit = -1;
            int selectedPos = -1;
            
            for (int j = 0; j < available.length; j++) {
                if (available[j] != -1) {
                    if (count == pos) {
                        selectedDigit = available[j];
                        selectedPos = j;
                        break;
                    }
                    count++;
                }
            }
            
            result[i] = selectedDigit;
            available[selectedPos] = -1;
            index %= fact;
        }
        
        return result;
    }
}
