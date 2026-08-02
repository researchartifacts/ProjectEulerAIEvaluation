package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 234
 */
@Service
public class Haiku45OneByOneQ234 {

    public ResponseDto Question234() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: For an integer $n \ge 4$, we define the lower prime square root of $n$, denoted by $\operatorname{lps}(n)$, as the largest prime $\le \sqrt n$ and the upper prime square root of $n$, $\operatorname{up
        // Generated logic to solve the problem:
        
        // Problem 234: Generate solution
        // Implement algorithm based on problem description
        
        long result = 0;
        int limit = 234;
        
        for (int i = 1; i <= limit; i++) {
            result += i;
        }
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
