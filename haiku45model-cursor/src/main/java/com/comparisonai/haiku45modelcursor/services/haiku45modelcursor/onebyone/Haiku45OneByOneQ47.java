package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 47
 */
@Service
public class Haiku45OneByOneQ47 {

    public ResponseDto Question47() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Find first four consecutive integers each with four distinct prime factors
        // Generated logic to solve the problem:
        
        long result = 0;
        
        // Search for four consecutive numbers each with exactly 4 distinct prime factors
        for (int n = 2; n < 1000000; n++) {
            int factors1 = countDistinctPrimeFactors(n);
            int factors2 = countDistinctPrimeFactors(n + 1);
            int factors3 = countDistinctPrimeFactors(n + 2);
            int factors4 = countDistinctPrimeFactors(n + 3);
            
            if (factors1 == 4 && factors2 == 4 && factors3 == 4 && factors4 == 4) {
                result = n;
                break;
            }
        }
        
        Object answer = result;
        
        responseDto.setAnswer(answer);
        return responseDto;
    }
    
    private int countDistinctPrimeFactors(long n) {
        int count = 0;
        
        // Check for factor 2
        if (n % 2 == 0) {
            count++;
            while (n % 2 == 0) {
                n /= 2;
            }
        }
        
        // Check for odd factors from 3
        for (long i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                count++;
                while (n % i == 0) {
                    n /= i;
                }
            }
        }
        
        // If n is still greater than 1, it's a prime factor
        if (n > 1) {
            count++;
        }
        
        return count;
    }
}
