package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 451
 * Find the sum of I(n) for 3 <= n <= 2 * 10^7
 * where I(n) is the largest positive number m < n-1 such that m^2 mod n = 1
 */
@Service
public class Haiku45OneByOneQ451 {

    public ResponseDto Question451() {
        ResponseDto responseDto = new ResponseDto();
        
        long limit = 2 * 10_000_000L;
        long sum = 0;
        
        // For each n from 3 to limit
        for (long n = 3; n <= limit; n++) {
            // Find largest m < n-1 where m is coprime to n and m^2 mod n = 1
            long result = findLargestModularInverse(n);
            sum += result;
        }
        
        responseDto.setAnswer(sum);
        return responseDto;
    }
    
    private long findLargestModularInverse(long n) {
        // Find the largest m < n-1 such that m^2 mod n = 1
        // This means m is its own modular inverse
        for (long m = n - 2; m >= 1; m--) {
            if ((m * m) % n == 1) {
                return m;
            }
        }
        return 0;
    }
}
