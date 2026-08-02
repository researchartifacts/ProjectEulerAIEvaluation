package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 746
 * $n$ families, each with four members, a father, a mother, a son and a daughter, were invited to a re...
 */
@Service
public class Haiku45OneByOneQ746 {

    public ResponseDto Question746() {
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

