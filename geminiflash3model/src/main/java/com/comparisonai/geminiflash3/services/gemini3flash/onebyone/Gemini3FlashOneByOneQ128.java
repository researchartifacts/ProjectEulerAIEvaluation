package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ128 {

    public ResponseDto Question128() {
        ResponseDto responseDto = new ResponseDto();
        int target = 2000;
        int count = 1; // n=1 is in the sequence
        long r = 1;
        while (true) {
            // Start of ring r
            if (isPrime(6 * r - 1) && isPrime(6 * r + 1) && isPrime(12 * r + 7)) {
                count++;
                if (count == target) {
                    responseDto.setAnswer(String.valueOf(3 * r * r - 3 * r + 2));
                    return responseDto;
                }
            }
            // End of ring r
            if (isPrime(6 * r + 1) && isPrime(6 * r + 5) && isPrime(12 * r - 7)) {
                count++;
                if (count == target) {
                    responseDto.setAnswer(String.valueOf(3 * r * r + 3 * r + 1));
                    return responseDto;
                }
            }
            r++;
        }
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
