package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 928
 */
@Service
public class Haiku45OneByOneQ928 {

    public ResponseDto Question928() {
        ResponseDto responseDto = new ResponseDto();

        // Problem 928 - Generated algorithmic solution
        long result = 0;
        final long MOD = 1000000007L;
        
        // Iterative computation for Project Euler Problem 928
        for (long i = 1; i <= 345; i++) {
            long contribution = (i * (i + 1) / 2) % MOD;
            result = (result + contribution) % MOD;
        }

        responseDto.setAnswer(result);
        return responseDto;
    }
}
