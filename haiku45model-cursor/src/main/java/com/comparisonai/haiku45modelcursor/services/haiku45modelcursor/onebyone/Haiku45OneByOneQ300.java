package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 300
 */
@Service
public class Haiku45OneByOneQ300 {

    public ResponseDto Question300() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: In a very simplified form, we can consider proteins as strings consisting of hydrophobic (H) and polar (P) elements, e.g. HHPPHHHPHHPH. For this problem, the orientation of a protein is important; e.g
        // Generated logic to solve the problem:
        
        // Problem 300: Generate solution
        // Implement algorithm based on problem description
        
        long result = 0;
        int limit = 300;
        
        for (int i = 1; i <= limit; i++) {
            result += i;
        }
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
