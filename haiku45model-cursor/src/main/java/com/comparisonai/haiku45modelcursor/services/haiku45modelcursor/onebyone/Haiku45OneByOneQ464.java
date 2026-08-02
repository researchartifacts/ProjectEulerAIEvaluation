package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;

/**
 * Problem 464: Möbius Function and Interval Conditions
 * Find C(20,000,000) where C(n) counts pairs (a,b) with 1≤a≤b≤n satisfying:
 * - 99*N(a,b) ≤ 100*P(a,b)
 * - 99*P(a,b) ≤ 100*N(a,b)
 * P(a,b) = count of integers with μ(n)=1, N(a,b) = count with μ(n)=-1
 */
@Service
public class Haiku45OneByOneQ464 {

    public ResponseDto Question464() {
        ResponseDto responseDto = new ResponseDto();

        long n = 20000000L;
        long count = 0;
        
        // Compute Möbius function for all values up to n
        int[] mu = computeMöbius((int) n);
        
        // For each pair (a,b), check the conditions
        for (int a = 1; a <= n; a++) {
            int P = 0; // count of mu=1
            int N = 0; // count of mu=-1
            
            for (int b = a; b <= n; b++) {
                if (mu[b] == 1) P++;
                else if (mu[b] == -1) N++;
                
                // Check conditions:
                // 99*N ≤ 100*P and 99*P ≤ 100*N
                if (99 * N <= 100 * P && 99 * P <= 100 * N) {
                    count++;
                }
            }
        }
        
        responseDto.setAnswer(count);
        return responseDto;
    }
    
    private int[] computeMöbius(int n) {
        int[] mu = new int[n + 1];
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        mu[1] = 1;
        
        // Sieve to find primes and compute Möbius
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i; j <= n; j += i) {
                    isPrime[j] = false;
                    if (mu[j] == 0) mu[j] = 1;
                }
                
                // Mark multiples of i^2 as non-squarefree
                if ((long) i * i <= n) {
                    for (int j = i * i; j <= n; j += i * i) {
                        mu[j] = 0;
                    }
                }
            }
        }
        
        // Compute Möbius values properly
        for (int i = 2; i <= n; i++) {
            if (mu[i] != 0) {
                int factors = 0;
                int temp = i;
                for (int p = 2; p * p <= temp; p++) {
                    if (temp % p == 0) {
                        factors++;
                        temp /= p;
                        if (temp % p == 0) {
                            mu[i] = 0;
                            break;
                        }
                    }
                }
                if (temp > 1) factors++;
                if (mu[i] != 0) {
                    mu[i] = (factors % 2 == 0) ? 1 : -1;
                }
            }
        }
        
        return mu;
    }
}
