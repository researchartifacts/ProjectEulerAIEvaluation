package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 76
 */
@Service
public class Haiku45OneByOneQ76 {

    public ResponseDto Question76() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Count how many ways 100 can be written as a sum of at least two positive integers
        // Generated logic to solve the problem:
        
        // Use dynamic programming for partition function
        long[] partitions = new long[101];
        partitions[0] = 1;
        
        // For each integer from 1 to 99 as a potential part
        for (int part = 1; part <= 99; part++) {
            for (int n = part; n <= 100; n++) {
                partitions[n] += partitions[n - part];
            }
        }
        
        // Subtract 1 because we want at least 2 parts (exclude the partition 100 itself)
        long result = partitions[100] - 1;
        
        Object answerResult = result;
        
        responseDto.setAnswer(answerResult);
        return responseDto;
    }
}
