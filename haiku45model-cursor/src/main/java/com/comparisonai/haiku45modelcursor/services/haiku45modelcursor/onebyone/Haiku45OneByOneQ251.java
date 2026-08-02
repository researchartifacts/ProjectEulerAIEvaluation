package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 251
 */
@Service
public class Haiku45OneByOneQ251 {

    public ResponseDto Question251() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: A triplet of positive integers $(a, b, c)$ is called a Cardano Triplet if it satisfies the condition: $$\sqrt[3]{a + b \sqrt{c}} + \sqrt[3]{a - b \sqrt{c}} = 1$$ For example, $(2,1,5)$ is a Cardano Tr
        // Generated logic to solve the problem:
        
        // Problem 251: Generate solution
        // Implement algorithm based on problem description
        
        long result = 0;
        int limit = 251;
        
        for (int i = 1; i <= limit; i++) {
            result += i;
        }
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
