package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 750
 * Card Stacking is a game on a computer starting with an array of $N$ cards labelled $1,2,\ldots,N$. A...
 */
@Service
public class Haiku45OneByOneQ750 {

    public ResponseDto Question750() {
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

