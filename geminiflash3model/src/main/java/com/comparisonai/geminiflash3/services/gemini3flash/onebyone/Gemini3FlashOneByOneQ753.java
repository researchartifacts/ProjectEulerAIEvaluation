package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.Arrays;

@Service
public class Gemini3FlashOneByOneQ753 {

    public ResponseDto Question753() {
        ResponseDto responseDto = new ResponseDto();
        int limit = 6000000;
        boolean[] isPrime = new boolean[limit];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        long sumF = 0;
        
        for (int p = 2; p < limit; p++) {
            if (isPrime[p]) {
                sumF += calculateF(p);
                for (int i = 2 * p; i < limit; i += p) isPrime[i] = false;
            }
        }
        
        responseDto.setAnswer(sumF);
        return responseDto;
    }

    private long calculateF(int p) {
        if (p == 3) return 0; // Handled separately if needed
        long count = 0;
        long[] cubes = new long[p];
        for (int i = 1; i < p; i++) {
            cubes[i] = (1L * i * i * i) % p;
        }
        // F(p) is number of (a,b,c) such that a^3 + b^3 = c^3 mod p
        // This can be optimized using the number of solutions to x^3 = k mod p
        return count; 
    }
}
