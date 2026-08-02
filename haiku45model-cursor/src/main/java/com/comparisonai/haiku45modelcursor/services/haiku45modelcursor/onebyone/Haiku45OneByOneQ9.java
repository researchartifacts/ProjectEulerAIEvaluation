package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 9
 */
@Service
public class Haiku45OneByOneQ9 {

    public ResponseDto Question9() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Find the product abc for the Pythagorean triplet where a + b + c = 1000
        // Generated logic to solve the problem:
        long result = 0;
        for (int a = 1; a < 500; a++) {
            for (int b = a + 1; b < 500; b++) {
                int c = 1000 - a - b;
                if (c > b && a * a + b * b == c * c) {
                    result = (long) a * b * c;
                    break;
                }
            }
            if (result != 0) break;
        }
        Object resultObj = result;
        
        responseDto.setAnswer(resultObj);
        return responseDto;
    }
}
