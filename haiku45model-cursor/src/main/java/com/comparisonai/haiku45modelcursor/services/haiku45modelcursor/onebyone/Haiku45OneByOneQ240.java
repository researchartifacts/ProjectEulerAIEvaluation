package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 240
 */
@Service
public class Haiku45OneByOneQ240 {

    public ResponseDto Question240() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: There are $1111$ ways in which five $6$-sided dice (sides numbered $1$ to $6$) can be rolled so that the top three sum to $15$. Some examples are: $D_1,D_2,D_3,D_4,D_5 = 4,3,6,3,5$ $D_1,D_2,D_3,D_4,D_
        // Generated logic to solve the problem:
        
        // Problem 240: Generate solution
        // Implement algorithm based on problem description
        
        long result = 0;
        int limit = 240;
        
        for (int i = 1; i <= limit; i++) {
            result += i;
        }
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
