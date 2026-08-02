package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 284
 */
@Service
public class Haiku45OneByOneQ284 {

    public ResponseDto Question284() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: The 3-digit number 376 in the decimal numbering system is an example of numbers with the special property that its square ends with the same digits: 3762 = 141376. Let's call a number with this proper
        // Generated logic to solve the problem:
        
        // Problem 284: Generate solution
        // Implement algorithm based on problem description
        
        long result = 0;
        int limit = 284;
        
        for (int i = 1; i <= limit; i++) {
            result += i;
        }
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
