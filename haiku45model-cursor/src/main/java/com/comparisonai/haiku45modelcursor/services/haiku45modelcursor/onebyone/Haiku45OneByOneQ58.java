package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 58
 */
@Service
public class Haiku45OneByOneQ58 {

    public ResponseDto Question58() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Find the side length of square spiral where ratio of primes on diagonals 
        // first falls below 10%
        // Generated logic to solve the problem:
        
        java.util.function.Function<Long, Boolean> isPrime = n -> {
            if (n < 2) return false;
            if (n == 2) return true;
            if (n % 2 == 0) return false;
            for (long i = 3; i * i <= n; i += 2) {
                if (n % i == 0) return false;
            }
            return true;
        };
        
        long primeCount = 0;
        long diagonalCount = 1;
        long corner = 1;
        long sideLength = 1;
        
        for (long step = 1; ; step++) {
            for (int dir = 0; dir < 4; dir++) {
                for (long i = 0; i < 2 * step; i++) {
                    corner += 2 * step;
                    if (isPrime.apply(corner)) primeCount++;
                    diagonalCount++;
                    
                    if (diagonalCount > 1 && primeCount * 10 < diagonalCount) {
                        sideLength = 2 * step + 1;
                        responseDto.setAnswer(sideLength);
                        return responseDto;
                    }
                }
            }
        }
    }
}
