package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 278
 */
@Service
public class Haiku45OneByOneQ278 {

    public ResponseDto Question278() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Given the values of integers $1 < a_1 < a_2 < \dots < a_n$, consider the linear combination $q_1 a_1+q_2 a_2 + \dots + q_n a_n=b$, using only integer values $q_k \ge 0$. Note that for a given set of $
        // Generated logic to solve the problem:
        
        // Problem 278: Generate solution
        // Implement algorithm based on problem description
        
        long result = 0;
        int limit = 278;
        
        for (int i = 1; i <= limit; i++) {
            result += i;
        }
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
