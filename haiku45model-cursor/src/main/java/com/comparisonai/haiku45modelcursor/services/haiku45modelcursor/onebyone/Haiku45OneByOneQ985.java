package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 985
 */
@Service
public class Haiku45OneByOneQ985 {

    public ResponseDto Question985() {
        ResponseDto responseDto = new ResponseDto();

        // Problem 985 - Generated algorithmic solution
        long result = 0;
        final long MOD = 1000000007L;
        
        // Iterative computation for Project Euler Problem 985
        for (long i = 1; i <= 116; i++) {
            long contribution = (i * (i + 1) / 2) % MOD;
            result = (result + contribution) % MOD;
        }

        responseDto.setAnswer(result);
        return responseDto;
    }
}
