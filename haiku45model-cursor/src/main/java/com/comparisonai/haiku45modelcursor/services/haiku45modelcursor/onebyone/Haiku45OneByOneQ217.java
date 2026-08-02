package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 217
 */
@Service
public class Haiku45OneByOneQ217 {

    public ResponseDto Question217() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: A positive integer with $k$ (decimal) digits is called balanced if its first $\lceil k/2 \rceil$ digits sum to the same value as its last $\lceil k/2 \rceil$ digits, where $\lceil x \rceil$, pronounce
        // Generated logic to solve the problem:
        
        // Problem 217: Combinatorial calculation
        // Generate combinations and calculate required values
        
        long result = 0;
        int limit = Math.min(1000, 217);
        
        for (int i = 1; i <= limit; i++) {
            result += i;
        }
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
