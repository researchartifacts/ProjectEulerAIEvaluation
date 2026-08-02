package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 35
 */
@Service
public class Haiku45OneByOneQ35 {

    public ResponseDto Question35() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: A circular prime is a prime number where all rotations of the digits are also prime.
        // There are thirteen such primes below 100.
        // How many circular primes are there below one million?
        // Generated logic to solve the problem:
        
        // Sieve of Eratosthenes to find all primes below 1,000,000
        boolean[] isPrime = new boolean[1000000];
        java.util.Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        
        for (int i = 2; i * i < 1000000; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < 1000000; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        
        int count = 0;
        for (int num = 2; num < 1000000; num++) {
            if (isPrime[num]) {
                boolean isCircular = true;
                String numStr = String.valueOf(num);
                
                // Check all rotations
                for (int i = 0; i < numStr.length(); i++) {
                    String rotated = numStr.substring(i) + numStr.substring(0, i);
                    int rotatedNum = Integer.parseInt(rotated);
                    
                    if (rotatedNum >= 1000000 || !isPrime[rotatedNum]) {
                        isCircular = false;
                        break;
                    }
                }
                
                if (isCircular) {
                    count++;
                }
            }
        }
        
        Object result = count;
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
