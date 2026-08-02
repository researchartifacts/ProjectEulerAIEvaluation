package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 57
 */
@Service
public class Haiku45OneByOneQ57 {

    public ResponseDto Question57() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: In the first one-thousand expansions of sqrt(2), how many fractions have 
        // numerator with more digits than denominator?
        // Generated logic to solve the problem:
        
        int result = 0;
        java.math.BigInteger num = java.math.BigInteger.valueOf(3);
        java.math.BigInteger den = java.math.BigInteger.valueOf(2);
        
        for (int i = 1; i < 1000; i++) {
            if (num.toString().length() > den.toString().length()) {
                result++;
            }
            // Next iteration: (num + 2*den) / (num + den)
            java.math.BigInteger nextNum = num.add(den.multiply(java.math.BigInteger.valueOf(2)));
            java.math.BigInteger nextDen = num.add(den);
            num = nextNum;
            den = nextDen;
        }
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
