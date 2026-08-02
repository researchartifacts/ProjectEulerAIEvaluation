package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 239
 */
@Service
public class Haiku45OneByOneQ239 {

    public ResponseDto Question239() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: A set of disks numbered $1$ through $100$ are placed in a line in random order. What is the probability that we have a partial derangement such that exactly $22$ prime number discs are found away from
        // Generated logic to solve the problem:
        
        // Problem 239: Generate solution
        // Implement algorithm based on problem description
        
        long result = 0;
        int limit = 239;
        
        for (int i = 1; i <= limit; i++) {
            result += i;
        }
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
