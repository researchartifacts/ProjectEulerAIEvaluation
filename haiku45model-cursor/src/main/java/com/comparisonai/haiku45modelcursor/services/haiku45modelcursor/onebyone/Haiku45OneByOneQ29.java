package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.Set;
import java.math.BigInteger;

/**
 * Problem 29
 */
@Service
public class Haiku45OneByOneQ29 {

    public ResponseDto Question29() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Find count of distinct terms in a^b for 2 <= a <= 100 and 2 <= b <= 100
        // Generated logic to solve the problem:
        Set<String> distinctTerms = new HashSet<>();
        
        for (int a = 2; a <= 100; a++) {
            for (int b = 2; b <= 100; b++) {
                // Calculate a^b and store as string for uniqueness
                BigInteger result = BigInteger.valueOf(a).pow(b);
                distinctTerms.add(result.toString());
            }
        }
        
        Object result = distinctTerms.size();
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
