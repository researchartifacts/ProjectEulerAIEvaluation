package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ110 {

    public ResponseDto Question110() {
        ResponseDto responseDto = new ResponseDto();
        // Number of solutions for (x-n)(y-n) = n^2 is (d(n^2) + 1) / 2
        // If n = p1^a1 * p2^a2 * ... then n^2 = p1^2a1 * p2^2a2 * ...
        // d(n^2) = (2a1+1)(2a2+1)...
        // We want (2a1+1)(2a2+1)... > 8,000,000 - 1
        
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47};
        long minN = findMinN(0, 1, 1, primes);
        responseDto.setAnswer(String.valueOf(minN));
        return responseDto;
    }

    private long findMinN(int primeIdx, long currentN, long currentDivisors, int[] primes) {
        if (currentDivisors > 8000000) return currentN;
        if (primeIdx == primes.length) return Long.MAX_VALUE;

        long min = Long.MAX_VALUE;
        for (int a = 1; ; a++) {
            long nextN = currentN;
            for (int i = 0; i < a; i++) {
                if (Long.MAX_VALUE / primes[primeIdx] < nextN) {
                    nextN = -1;
                    break;
                }
                nextN *= primes[primeIdx];
            }
            if (nextN == -1) break;
            
            long res = findMinN(primeIdx + 1, nextN, currentDivisors * (2 * a + 1), primes);
            if (res == Long.MAX_VALUE) break; // Should not happen easily
            min = Math.min(min, res);
            
            // Optimization: exponents should be non-increasing
            if (primeIdx > 0 && a == 1) break; 
        }
        return min;
    }
}
