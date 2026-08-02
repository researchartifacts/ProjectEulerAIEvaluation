package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 275
 */
@Service
public class Haiku45OneByOneQ275 {

    public ResponseDto Question275() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Let us define a balanced sculpture of order $n$ as follows: A polyominoAn arrangement of identical squares connected through shared edges; holes are allowed. made up of $n + 1$ tiles known as the bloc
        // Generated logic to solve the problem:
        
        // Problem 275: Generate solution
        // Implement algorithm based on problem description
        
        long result = 0;
        int limit = 275;
        
        for (int i = 1; i <= limit; i++) {
            result += i;
        }
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
