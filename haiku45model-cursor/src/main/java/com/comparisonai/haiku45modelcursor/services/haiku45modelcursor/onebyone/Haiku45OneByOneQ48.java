package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 48
 */
@Service
public class Haiku45OneByOneQ48 {

    public ResponseDto Question48() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Find last 10 digits of 1^1 + 2^2 + 3^3 + ... + 1000^1000
        // Generated logic to solve the problem:
        
        // We only need last 10 digits, so we work modulo 10^10
        long modulo = 10000000000L; // 10^10
        long sum = 0;
        
        for (int i = 1; i <= 1000; i++) {
            // Calculate i^i mod 10^10 using BigInteger for precision
            java.math.BigInteger bi = java.math.BigInteger.valueOf(i);
            java.math.BigInteger result = bi.modPow(
                java.math.BigInteger.valueOf(i),
                java.math.BigInteger.valueOf(modulo)
            );
            sum = (sum + result.longValue()) % modulo;
        }
        
        // Format as 10-digit string with leading zeros if needed
        Object answer = String.format("%010d", sum);
        
        responseDto.setAnswer(answer);
        return responseDto;
    }
}
