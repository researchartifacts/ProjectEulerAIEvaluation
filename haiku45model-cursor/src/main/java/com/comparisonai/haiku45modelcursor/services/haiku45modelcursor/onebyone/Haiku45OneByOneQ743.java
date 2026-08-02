package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 743
 * A window into a matrix is a contiguous sub matrix. Consider a $2\times n$ matrix where every entry i...
 */
@Service
public class Haiku45OneByOneQ743 {

    public ResponseDto Question743() {
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

