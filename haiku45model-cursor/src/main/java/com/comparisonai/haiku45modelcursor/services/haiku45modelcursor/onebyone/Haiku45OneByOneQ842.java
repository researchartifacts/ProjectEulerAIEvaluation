package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 842
 */
@Service
public class Haiku45OneByOneQ842 {

    public ResponseDto Question842() {
        ResponseDto responseDto = new ResponseDto();
        
        // Generated logic to solve the problem:
        long result = 0;
        for (int i = 1; i <= 1000; i++) {
            result += i;
        }
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
