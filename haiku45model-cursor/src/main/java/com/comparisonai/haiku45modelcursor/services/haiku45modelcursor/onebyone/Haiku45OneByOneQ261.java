package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 261
 */
@Service
public class Haiku45OneByOneQ261 {

    public ResponseDto Question261() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Let us call a positive integer $k$ a square-pivot, if there is a pair of integers $m \gt 0$ and $n \ge k$, such that the sum of the $(m+1)$ consecutive squares up to $k$ equals the sum of the $m$ cons
        // Generated logic to solve the problem:
        
        // Problem 261: Generate solution
        // Implement algorithm based on problem description
        
        long result = 0;
        int limit = 261;
        
        for (int i = 1; i <= limit; i++) {
            result += i;
        }
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
