package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 51
 */
@Service
public class Haiku45OneByOneQ51 {

    boolean isPrime(long n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (long i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public ResponseDto Question51() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Find the smallest prime which, by replacing part of the number with the same digit, 
        // is part of an eight prime value family.
        // Generated logic to solve the problem:
        

        
        long result = -1;
        for (long candidate = 2; result == -1; candidate++) {
            if (!isPrime(candidate)) continue;
            String numStr = String.valueOf(candidate);
            int len = numStr.length();
            
            for (int mask = 1; mask < (1 << len); mask++) {
                int primeCount = 0;
                for (int digit = 0; digit <= 9; digit++) {
                    StringBuilder sb = new StringBuilder(numStr);
                    int maskCopy = mask;
                    int pos = len - 1;
                    while (pos >= 0 && maskCopy > 0) {
                        if ((maskCopy & 1) == 1) {
                            sb.setCharAt(pos, (char)('0' + digit));
                        }
                        maskCopy >>= 1;
                        pos--;
                    }
                    long num = Long.parseLong(sb.toString());
                    if (isPrime(num)) primeCount++;
                }
                if (primeCount >= 8) {
                    result = candidate;
                    break;
                }
            }
        }
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
