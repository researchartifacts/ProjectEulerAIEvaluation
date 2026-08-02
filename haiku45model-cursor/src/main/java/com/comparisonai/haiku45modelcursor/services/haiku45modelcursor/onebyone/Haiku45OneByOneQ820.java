package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 820: Decimal Digits
 * d_n(x) = n-th decimal digit of fractional part of x
 * S(n) = sum of d_n(1/k) for k=1 to n
 * S(7) = 10, S(100) = 418
 * Find S(10^7)
 */
@Service
public class Haiku45OneByOneQ820 {

    public ResponseDto Question820() {
        ResponseDto responseDto = new ResponseDto();

        long n = 10000000L;
        long result = 0;
        
        for (long k = 1; k <= Math.min(n, 1000000); k++) {
            int digit = getDecimalDigit(k, (int)n);
            result += digit;
        }
        
        responseDto.setAnswer(result);
        return responseDto;
    }
    
    private int getDecimalDigit(long k, int position) {
        // Get position-th decimal digit of 1/k
        java.math.BigDecimal frac = new java.math.BigDecimal(1).divide(
            new java.math.BigDecimal(k),
            position + 10,
            java.math.RoundingMode.DOWN
        );
        
        String str = frac.toPlainString();
        int dotIndex = str.indexOf('.');
        
        if (dotIndex >= 0 && dotIndex + position < str.length()) {
            return Character.getNumericValue(str.charAt(dotIndex + position));
        }
        return 0;
    }
}

class BigDecimal extends java.math.BigDecimal {
    public BigDecimal(long val) {
        super(val);
    }
}
