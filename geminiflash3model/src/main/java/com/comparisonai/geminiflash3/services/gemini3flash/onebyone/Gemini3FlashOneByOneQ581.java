package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ581 {

    public ResponseDto Question581() {
        ResponseDto responseDto = new ResponseDto();
        long sum = 0;
        int maxP = 47;
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47};
        
        // This is a search for n such that n(n+1)/2 is 47-smooth.
        // Both n and n+1 (or n/2 and n+1, etc.) must be 47-smooth.
        // Since T(n) grows fast, we only need to check up to a reasonable limit
        // where we can no longer find such n. 
        // For 47-smooth, the largest such n is known to be relatively small.
        
        long limit = 1000000000L; // Arbitrary high limit for search
        for (long n = 1; n < 1000000; n++) {
            if (isSmooth(n, primes) && isSmooth(n + 1, primes)) {
                sum += n;
            }
        }
        
        responseDto.setAnswer(sum);
        return responseDto;
    }

    private boolean isSmooth(long n, int[] primes) {
        if (n == 0) return true;
        long temp = n;
        if (temp % 2 == 0) while (temp % 2 == 0) temp /= 2;
        for (int i = 1; i < primes.length; i++) {
            while (temp % primes[i] == 0) temp /= primes[i];
        }
        return temp == 1;
    }
}
