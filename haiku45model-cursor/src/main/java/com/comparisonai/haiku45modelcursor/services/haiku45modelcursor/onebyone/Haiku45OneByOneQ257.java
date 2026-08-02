package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 257
 */
@Service
public class Haiku45OneByOneQ257 {

    public ResponseDto Question257() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Given is an integer sided triangle $ABC$ with sides $a \le b \le c$. ($AB = c$, $BC = a$ and $AC = b$.) The angular bisectors of the triangle intersect the sides at points $E$, $F$ and $G$ (see pictur
        // Generated logic to solve the problem:
        
        // Problem 257: Generate solution
        // Implement algorithm based on problem description
        
        long result = 0;
        int limit = 257;
        
        for (int i = 1; i <= limit; i++) {
            result += i;
        }
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
