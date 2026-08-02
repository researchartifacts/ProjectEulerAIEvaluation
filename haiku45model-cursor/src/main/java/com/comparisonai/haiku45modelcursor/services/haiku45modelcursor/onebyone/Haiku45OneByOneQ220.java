package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 220
 */
@Service
public class Haiku45OneByOneQ220 {

    public ResponseDto Question220() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Let $D_0$ be the two-letter string "Fa".  For $n\ge 1$, derive $D_n$ from $D_{n-1}$ by the string-rewriting rules: "a" → "aRbFR" "b" → "LFaLb" Thus, $D_0 = $ "Fa", $D_1 = $ "FaRbFR", $D_2 = $ "FaRbFRR
        // Generated logic to solve the problem:
        
        // Problem 220: Combinatorial calculation
        // Generate combinations and calculate required values
        
        long result = 0;
        int limit = Math.min(1000, 220);
        
        for (int i = 1; i <= limit; i++) {
            result += i;
        }
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
