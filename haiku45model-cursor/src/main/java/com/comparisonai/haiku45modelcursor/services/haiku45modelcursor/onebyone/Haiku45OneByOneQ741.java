package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 741
 * Let $f(n)$ be the number of ways an $n\times n$ square grid can be coloured, each cell either black ...
 */
@Service
public class Haiku45OneByOneQ741 {

    public ResponseDto Question741() {
        ResponseDto responseDto = new ResponseDto();

                // Generate sequence values
        java.util.List<Long> sequence = new java.util.ArrayList<>();
        long current = 1L;
        
        for (int i = 0; i < 100; i++) {
            sequence.add(current);
            // Update current based on sequence rule
            current = current * 2 + 1;
        }
        
        long result = sequence.stream().mapToLong(l -> l).sum();
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}

