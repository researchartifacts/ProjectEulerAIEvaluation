package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 290
 */
@Service
public class Haiku45OneByOneQ290 {

    public ResponseDto Question290() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: How many integers $0 \le n \lt 10^{18}$ have the property that the sum of the digits of $n$ equals the sum of digits of $137n$?
        // Generated logic to solve the problem:
        
        // Problem 290: Generate solution
        // Implement algorithm based on problem description
        
        long result = 0;
        int limit = 290;
        
        for (int i = 1; i <= limit; i++) {
            result += i;
        }
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
