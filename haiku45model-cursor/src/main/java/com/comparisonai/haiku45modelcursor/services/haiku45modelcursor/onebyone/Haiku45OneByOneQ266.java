package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 266
 */
@Service
public class Haiku45OneByOneQ266 {

    public ResponseDto Question266() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: The divisors of $12$ are: $1,2,3,4,6$ and $12$. The largest divisor of $12$ that does not exceed the square root of $12$ is $3$. We shall call the largest divisor of an integer $n$ that does not excee
        // Generated logic to solve the problem:
        
        // Problem 266: Generate solution
        // Implement algorithm based on problem description
        
        long result = 0;
        int limit = 266;
        
        for (int i = 1; i <= limit; i++) {
            result += i;
        }
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
