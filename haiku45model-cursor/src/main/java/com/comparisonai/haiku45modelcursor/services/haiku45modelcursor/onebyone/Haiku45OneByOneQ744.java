package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 744
 * "What? Where? When?" is a TV game show in which a team of experts attempt to answer questions. The f...
 */
@Service
public class Haiku45OneByOneQ744 {

    public ResponseDto Question744() {
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

