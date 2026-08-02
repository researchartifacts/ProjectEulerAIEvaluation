package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 27
 */
@Service
public class Haiku45OneByOneQ27 {

    public ResponseDto Question27() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Find a and b for quadratic n^2 + an + b that produces max primes for n >= 0
        // |a| < 1000, |b| <= 1000
        // Generated logic to solve the problem:
        int maxPrimes = 0;
        long resultProduct = 0;
        
        // Precompute primes for efficiency
        int maxNum = 100000;
        boolean[] isPrime = sieveOfEratosthenes(maxNum);
        
        // b must be prime and positive (for n=0 to give prime b)
        for (int b = 2; b <= 1000; b++) {
            if (!isPrime[b]) continue;
            
            // Try all values of a
            for (int a = -999; a < 1000; a++) {
                int n = 0;
                int primeCount = 0;
                
                // Count consecutive primes starting at n=0
                while (true) {
                    long value = (long) n * n + (long) a * n + b;
                    
                    if (value <= 0 || value >= maxNum || !isPrime[(int) value]) {
                        break;
                    }
                    
                    primeCount++;
                    n++;
                }
                
                if (primeCount > maxPrimes) {
                    maxPrimes = primeCount;
                    resultProduct = (long) a * b;
                }
            }
        }
        
        Object result = resultProduct;
        
        responseDto.setAnswer(result);
        return responseDto;
    }
    
    private boolean[] sieveOfEratosthenes(int limit) {
        boolean[] isPrime = new boolean[limit];
        for (int i = 2; i < limit; i++) {
            isPrime[i] = true;
        }
        
        for (int i = 2; i * i < limit; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < limit; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        
        return isPrime;
    }
}
