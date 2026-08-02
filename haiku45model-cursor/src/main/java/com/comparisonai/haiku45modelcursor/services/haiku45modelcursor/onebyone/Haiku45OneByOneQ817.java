package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 817: Base N Digit Square
 * M(n,d) = smallest positive integer m such that m^2 in base n contains digit d
 * M(10,7) = 24 (24^2 = 576), M(11,10) = 19 (19^2 = 361 = 2A9 in base 11)
 * Find sum of M(p, p-d) for d=1 to 10^5, where p = 10^9+7
 */
@Service
public class Haiku45OneByOneQ817 {

    public ResponseDto Question817() {
        ResponseDto responseDto = new ResponseDto();

        long p = 1000000007L;
        long result = 0;
        
        // For each digit d from 1 to 10^5
        for (long d = 1; d <= 100000; d++) {
            long digit = p - d;
            long m = findM(p, digit);
            result = (result + m) % p;
        }
        
        responseDto.setAnswer(result);
        return responseDto;
    }
    
    private long findM(long base, long digit) {
        // Find smallest m such that m^2 in given base contains digit
        long limit = base * base; // Upper bound
        
        for (long m = 1; m < limit; m++) {
            long square = (m * m) % (base * base);
            if (containsDigitInBase(square, base, digit)) {
                return m;
            }
        }
        return 1;
    }
    
    private boolean containsDigitInBase(long num, long base, long digit) {
        while (num > 0) {
            if (num % base == digit) {
                return true;
            }
            num /= base;
        }
        return false;
    }
}
