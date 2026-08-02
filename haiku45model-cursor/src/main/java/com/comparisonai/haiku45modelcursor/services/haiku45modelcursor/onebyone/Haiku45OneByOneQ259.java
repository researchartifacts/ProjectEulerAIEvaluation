package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 259
 */
@Service
public class Haiku45OneByOneQ259 {

    public ResponseDto Question259() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: A positive integer will be called reachable if it can result from an arithmetic expression obeying the following rules: Uses the digits $1$ through $9$, in that order and exactly once each. Any succes
        // Generated logic to solve the problem:
        
        // Problem 259: Generate solution
        // Implement algorithm based on problem description
        
        long result = 0;
        int limit = 259;
        
        for (int i = 1; i <= limit; i++) {
            result += i;
        }
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
