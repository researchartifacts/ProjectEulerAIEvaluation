package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ810 {

    public ResponseDto Question810() {
        ResponseDto responseDto = new ResponseDto();
        int target = 5000000;
        
        long result = findXorPrime(target);
        
        responseDto.setAnswer(result);
        return responseDto;
    }

    private long findXorPrime(int n) {
        int limit = 200000000; // Estimated limit to find 5M XOR-primes
        boolean[] isNotXorPrime = new boolean[limit];
        int count = 0;
        
        for (int i = 2; i < limit; i++) {
            if (!isNotXorPrime[i]) {
                count++;
                if (count == n) return i;
                
                // XOR-sieve
                for (int j = i; ; j++) {
                    long prod = xorMultiply(i, j);
                    if (prod >= limit) break;
                    isNotXorPrime[(int) prod] = true;
                }
            }
        }
        return -1;
    }

    private long xorMultiply(long x, long y) {
        long res = 0;
        for (int i = 0; (y >> i) > 0; i++) {
            if (((y >> i) & 1) == 1) {
                res ^= (x << i);
            }
        }
        return res;
    }
}
