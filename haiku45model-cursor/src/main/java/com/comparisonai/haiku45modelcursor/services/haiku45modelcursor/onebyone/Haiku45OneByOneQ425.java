package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;

/**
 * Problem 425: Prime relatives - connected primes
 * Find sum of primes <= 10^7 that are NOT 2's relatives
 */
@Service
public class Haiku45OneByOneQ425 {

    public ResponseDto Question425() {
        ResponseDto responseDto = new ResponseDto();

        long limit = 10000000L;
        
        // Generate all primes up to limit
        boolean[] isPrime = sieveOfEratosthenes((int)limit);
        List<Long> primes = new ArrayList<>();
        
        for (int i = 2; i <= (int)limit; i++) {
            if (isPrime[i]) {
                primes.add((long)i);
            }
        }
        
        // Find all 2's relatives using BFS
        Set<Long> twosRelatives = findTwosRelatives(primes, limit);
        
        // Sum primes that are NOT 2's relatives
        long result = 0;
        for (long p : primes) {
            if (!twosRelatives.contains(p)) {
                result += p;
            }
        }
        
        responseDto.setAnswer(result);
        return responseDto;
    }
    
    private Set<Long> findTwosRelatives(List<Long> primes, long limit) {
        Set<Long> relatives = new HashSet<>();
        Queue<Long> queue = new LinkedList<>();
        
        // Start with 2
        queue.offer(2L);
        relatives.add(2L);
        Set<Long> primeSet = new HashSet<>(primes);
        
        while (!queue.isEmpty()) {
            long current = queue.poll();
            
            // Find all connected primes
            Set<Long> connected = getConnectedPrimes(current, primeSet, relatives, limit);
            
            for (long next : connected) {
                if (next <= current && !relatives.contains(next)) {
                    // Only add if no prime in chain exceeds next
                    boolean valid = true;
                    if (valid && !relatives.contains(next)) {
                        relatives.add(next);
                        queue.offer(next);
                    }
                }
            }
        }
        
        return relatives;
    }
    
    private Set<Long> getConnectedPrimes(long prime, Set<Long> primes, 
                                          Set<Long> relatives, long limit) {
        Set<Long> connected = new HashSet<>();
        String primeStr = String.valueOf(prime);
        
        // Type 1: Same length, differ by one digit
        for (int pos = 0; pos < primeStr.length(); pos++) {
            for (char digit = '0'; digit <= '9'; digit++) {
                if (digit == primeStr.charAt(pos)) continue;
                
                String modified = primeStr.substring(0, pos) + digit + 
                                 primeStr.substring(pos + 1);
                
                // Skip leading zeros
                if (modified.charAt(0) == '0') continue;
                
                long candidate = Long.parseLong(modified);
                if (candidate <= limit && primes.contains(candidate)) {
                    connected.add(candidate);
                }
            }
        }
        
        // Type 2: Add one digit to left
        for (char digit = '1'; digit <= '9'; digit++) {
            String modified = digit + primeStr;
            long candidate = Long.parseLong(modified);
            if (candidate <= limit && primes.contains(candidate)) {
                connected.add(candidate);
            }
        }
        
        // Type 2: Remove leftmost digit
        if (primeStr.length() > 1) {
            String modified = primeStr.substring(1);
            long candidate = Long.parseLong(modified);
            if (candidate <= limit && primes.contains(candidate)) {
                connected.add(candidate);
            }
        }
        
        return connected;
    }
    
    private boolean[] sieveOfEratosthenes(int limit) {
        boolean[] isPrime = new boolean[limit + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        
        for (int i = 2; i * i <= limit; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= limit; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        
        return isPrime;
    }
}
