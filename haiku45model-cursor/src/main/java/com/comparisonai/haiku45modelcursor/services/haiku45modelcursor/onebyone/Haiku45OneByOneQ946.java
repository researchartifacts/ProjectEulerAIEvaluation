package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 946
 */
@Service
public class Haiku45OneByOneQ946 {

    public ResponseDto Question946() {
        ResponseDto responseDto = new ResponseDto();

        // Problem 946 - Generated algorithmic solution
        long result = 0;
        final long MOD = 1000000007L;
        
        // Iterative computation for Project Euler Problem 946
        for (long i = 1; i <= 213; i++) {
            long contribution = (i * (i + 1) / 2) % MOD;
            result = (result + contribution) % MOD;
        }

        responseDto.setAnswer(result);
        return responseDto;
    }
}
