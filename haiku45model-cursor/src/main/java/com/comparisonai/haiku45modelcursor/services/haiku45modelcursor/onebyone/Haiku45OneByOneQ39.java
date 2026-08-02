package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 39
 */
@Service
public class Haiku45OneByOneQ39 {

    public ResponseDto Question39() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: If p is the perimeter of a right angle triangle with integral length sides {a, b, c},
        // for which value of p ≤ 1000 is the number of solutions maximised?
        // Generated logic to solve the problem:
        
        int[] count = new int[1001];
        
        // For a right triangle: a² + b² = c², and a + b + c = p
        // Iterate through all possible combinations
        for (int a = 1; a <= 500; a++) {
            for (int b = a; b <= 500; b++) {
                int cSquared = a * a + b * b;
                
                // Check if c is an integer
                int c = (int) Math.sqrt(cSquared);
                if (c * c == cSquared) {
                    int p = a + b + c;
                    if (p <= 1000) {
                        count[p]++;
                    }
                }
            }
        }
        
        int maxP = 0;
        int maxCount = 0;
        for (int p = 1; p <= 1000; p++) {
            if (count[p] > maxCount) {
                maxCount = count[p];
                maxP = p;
            }
        }
        
        Object result = maxP;
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
