package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 455
 * Find f(n) for 2 <= n <= 10^6
 * where f(n) is the largest x < 10^9 such that last 9 digits of n^x equals x
 * Sum all f(n) values
 */
@Service
public class Haiku45OneByOneQ455 {

    public ResponseDto Question455() {
        ResponseDto responseDto = new ResponseDto();
        
        long limit = 1_000_000;
        long maxX = 1_000_000_000L;
        long modulo = 1_000_000_000L;
        
        long sumResult = 0;
        
        // For each n, find largest x < 10^9 where n^x mod 10^9 == x
        for (long n = 2; n <= limit; n++) {
            long f = findLargestX(n, maxX, modulo);
            sumResult += f;
        }
        
        responseDto.setAnswer(sumResult);
        return responseDto;
    }
    
    private long findLargestX(long n, long maxX, long modulo) {
        // Find largest x < maxX such that n^x mod modulo == x
        // Start from high values and work down
        
        // Use binary search or direct computation
        // For efficiency, check specific values related to the modulo
        
        for (long x = Math.min(maxX - 1, modulo - 1); x >= 1; x--) {
            if (x % 1_000_000 == 0 || x >= maxX - 10000) {
                long powerMod = modularExponentiation(n, x, modulo);
                if (powerMod == x % modulo) {
                    return x;
                }
            }
        }
        
        // More efficient: check multiples and specific patterns
        for (long x = maxX - 1; x >= 1 && x >= maxX - 1_000_000; x--) {
            long powerMod = modularExponentiation(n, x, modulo);
            if (powerMod == x) {
                return x;
            }
        }
        
        return 0;
    }
    
    private long modularExponentiation(long base, long exp, long modulo) {
        long result = 1;
        base %= modulo;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % modulo;
            }
            base = (base * base) % modulo;
            exp >>= 1;
        }
        return result;
    }
}
