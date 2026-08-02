package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 823: Factorial Matrix
 */
@Service
public class Haiku45OneByOneQ823 {

    public ResponseDto Question823() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;
        for (int i = 1; i <= 100; i++) {
            result += i * i * i;
        }
        responseDto.setAnswer(result);
        return responseDto;
    }
}
