package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ146 {

    public ResponseDto Question146() {
        ResponseDto responseDto = new ResponseDto();
        long limit = 150000000L;
        long sum = 0;
        
        // n must be a multiple of 10 because of the conditions n^2+1, +3, +7, +9, +13, +27 are primes.
        // For n not multiple of 10, some will be divisible by 2 or 5.
        // Actually n must end in 0. If n ends in 1, n^2+9 is even. If n ends in 2, n^2+1 is 5.
        // If n ends in 3, n^2+1 is even. If n ends in 4, n^2+1 is even.
        // If n ends in 5, n^2+1 is even. If n ends in 6, n^2+9 is 5.
        // If n ends in 7, n^2+1 is even. If n ends in 8, n^2+1 is 5.
        // If n ends in 9, n^2+1 is even.
        // So n must end in 0.
        
        for (long n = 10; n < limit; n += 10) {
            long n2 = n * n;
            if (isPrime(n2 + 1) && isPrime(n2 + 3) && isPrime(n2 + 7) && 
                isPrime(n2 + 9) && isPrime(n2 + 13) && isPrime(n2 + 27)) {
                
                // Also need to check if they are "consecutive" primes.
                // This means no other primes between n2+1 and n2+27.
                // Primes are n2+1, n2+3, n2+7, n2+9, n2+13, n2+27.
                // Primes between them would be n2+5, n2+11, n2+15, n2+17, n2+19, n2+21, n2+23, n2+25.
                // None of these should be prime.
                if (!isPrime(n2 + 5) && !isPrime(n2 + 11) && !isPrime(n2 + 15) && 
                    !isPrime(n2 + 17) && !isPrime(n2 + 19) && !isPrime(n2 + 21) && 
                    !isPrime(n2 + 23) && !isPrime(n2 + 25)) {
                    sum += n;
                }
            }
        }
        
        responseDto.setAnswer(sum);
        return responseDto;
    }

    private boolean isPrime(long n) {
        if (n < 2) return false;
        if (n == 2 || n == 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        for (long i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }
}
