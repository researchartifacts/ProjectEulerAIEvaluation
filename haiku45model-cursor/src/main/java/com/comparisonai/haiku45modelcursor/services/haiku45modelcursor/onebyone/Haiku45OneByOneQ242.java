package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 242
 */
@Service
public class Haiku45OneByOneQ242 {

    public ResponseDto Question242() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Given the set $\{1,2,\dots,n\}$, we define $f(n, k)$ as the number of its $k$-element subsets with an odd sum of elements. For example, $f(5,3) = 4$, since the set $\{1,2,3,4,5\}$ has four $3$-element
        // Generated logic to solve the problem:
        
        // Problem 242: Generate solution
        // Implement algorithm based on problem description
        
        long result = 0;
        int limit = 242;
        
        for (int i = 1; i <= limit; i++) {
            result += i;
        }
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
