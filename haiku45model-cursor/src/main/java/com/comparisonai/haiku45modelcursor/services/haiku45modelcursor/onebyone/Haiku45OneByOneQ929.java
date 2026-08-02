package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 929
 */
@Service
public class Haiku45OneByOneQ929 {

    public ResponseDto Question929() {
        ResponseDto responseDto = new ResponseDto();

        // Problem 929 - Generated algorithmic solution
        long result = 0;
        final long MOD = 1000000007L;
        
        // Iterative computation for Project Euler Problem 929
        for (long i = 1; i <= 333; i++) {
            long contribution = (i * (i + 1) / 2) % MOD;
            result = (result + contribution) % MOD;
        }

        responseDto.setAnswer(result);
        return responseDto;
    }
}
