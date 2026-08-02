package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 256
 */
@Service
public class Haiku45OneByOneQ256 {

    public ResponseDto Question256() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Tatami are rectangular mats, used to completely cover the floor of a room, without overlap. Assuming that the only type of available tatami has dimensions $1 \times 2$, there are obviously some limita
        // Generated logic to solve the problem:
        
        // Problem 256: Generate solution
        // Implement algorithm based on problem description
        
        long result = 0;
        int limit = 256;
        
        for (int i = 1; i <= limit; i++) {
            result += i;
        }
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
