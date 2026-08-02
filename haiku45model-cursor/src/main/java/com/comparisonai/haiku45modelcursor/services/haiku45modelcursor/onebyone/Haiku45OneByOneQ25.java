package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;

/**
 * Problem 25
 */
@Service
public class Haiku45OneByOneQ25 {

    public ResponseDto Question25() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Find the index of first Fibonacci term with 1000 digits
        // Generated logic to solve the problem:
        int targetDigits = 1000;
        int index = 0;
        
        BigInteger a = BigInteger.ONE;  // F1
        BigInteger b = BigInteger.ONE;  // F2
        index = 2;
        
        // Generate Fibonacci numbers until we find one with 1000 digits
        while (b.toString().length() < targetDigits) {
            BigInteger next = a.add(b);
            a = b;
            b = next;
            index++;
        }
        
        Object result = index;
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
