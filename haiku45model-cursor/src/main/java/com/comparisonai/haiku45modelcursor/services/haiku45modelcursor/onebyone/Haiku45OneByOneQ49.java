package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 49
 */
@Service
public class Haiku45OneByOneQ49 {

    public ResponseDto Question49() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Find 4-digit arithmetic sequence where terms are prime permutations
        // Return concatenation of the three terms (excluding 1487,4817,8147)
        // Generated logic to solve the problem:
        
        String result = "";
        
        // Generate all 4-digit primes
        java.util.List<Integer> primes = new java.util.ArrayList<>();
        for (int n = 1000; n < 10000; n++) {
            if (isPrime(n)) {
                primes.add(n);
            }
        }
        
        // Check all pairs for arithmetic sequences
        for (int i = 0; i < primes.size(); i++) {
            for (int j = i + 1; j < primes.size(); j++) {
                int p1 = primes.get(i);
                int p2 = primes.get(j);
                int diff = p2 - p1;
                int p3 = p2 + diff;
                
                // Check if p3 exists and is prime
                if (p3 < 10000 && isPrime(p3)) {
                    // Check if all three are permutations of each other
                    if (arePermutations(p1, p2, p3)) {
                        // Exclude the known sequence 1487, 4817, 8147
                        String seq = String.valueOf(p1) + String.valueOf(p2) + String.valueOf(p3);
                        if (!seq.equals("148748178147")) {
                            result = seq;
                            break;
                        }
                    }
                }
            }
            if (!result.isEmpty()) break;
        }
        
        Object answer = result;
        
        responseDto.setAnswer(answer);
        return responseDto;
    }
    
    private boolean isPrime(long n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (long i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }
    
    private boolean arePermutations(int a, int b, int c) {
        String sa = String.valueOf(a);
        String sb = String.valueOf(b);
        String sc = String.valueOf(c);
        
        char[] ca = sa.toCharArray();
        char[] cb = sb.toCharArray();
        char[] cc = sc.toCharArray();
        
        java.util.Arrays.sort(ca);
        java.util.Arrays.sort(cb);
        java.util.Arrays.sort(cc);
        
        return java.util.Arrays.equals(ca, cb) && java.util.Arrays.equals(cb, cc);
    }
}
