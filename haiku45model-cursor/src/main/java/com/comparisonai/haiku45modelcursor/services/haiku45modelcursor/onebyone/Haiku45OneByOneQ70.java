package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 70
 */
@Service
public class Haiku45OneByOneQ70 {

    public ResponseDto Question70() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Euler's totient function, \phi(n) [sometimes called the phi function], is use...
        // Generated logic to solve the problem:
        
        long result = 0;
        double minRatio = Double.MAX_VALUE;
        
        // Test all n up to 10^7
        for (long n = 2; n < 10000000; n++) {
            long phi = computeTotient(n);
            
            // Check if phi is a permutation of n
            if (isPermutation(n, phi)) {
                double ratio = (double) n / phi;
                if (ratio < minRatio) {
                    minRatio = ratio;
                    result = n;
                }
            }
        }
        
        Object answerResult = result;
        
        responseDto.setAnswer(answerResult);
        return responseDto;
    }
    
    private long computeTotient(long n) {
        long result = n;
        long temp = n;
        
        for (long p = 2; p * p <= temp; p++) {
            if (temp % p == 0) {
                while (temp % p == 0) {
                    temp /= p;
                }
                result = result / p * (p - 1);
            }
        }
        
        if (temp > 1) {
            result = result / temp * (temp - 1);
        }
        
        return result;
    }
    
    private boolean isPermutation(long a, long b) {
        char[] arrA = String.valueOf(a).toCharArray();
        char[] arrB = String.valueOf(b).toCharArray();
        
        if (arrA.length != arrB.length) {
            return false;
        }
        
        java.util.Arrays.sort(arrA);
        java.util.Arrays.sort(arrB);
        
        return java.util.Arrays.equals(arrA, arrB);
    }
}
