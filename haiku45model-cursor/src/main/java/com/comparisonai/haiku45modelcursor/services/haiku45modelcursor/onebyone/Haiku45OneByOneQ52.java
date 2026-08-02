package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 52
 */
@Service
public class Haiku45OneByOneQ52 {

    public ResponseDto Question52() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Find the smallest positive integer x such that 2x, 3x, 4x, 5x, and 6x contain the same digits
        // Generated logic to solve the problem:
        
        java.util.function.Function<Long, String> getDigits = (n) -> {
            String s = String.valueOf(n);
            char[] chars = s.toCharArray();
            java.util.Arrays.sort(chars);
            return new String(chars);
        };
        
        long result = -1;
        for (long x = 1; result == -1; x++) {
            String digits = getDigits.apply(x);
            boolean allMatch = true;
            for (int mult = 2; mult <= 6; mult++) {
                if (!getDigits.apply(x * mult).equals(digits)) {
                    allMatch = false;
                    break;
                }
            }
            if (allMatch) {
                result = x;
            }
        }
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
