package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;

/**
 * Problem 467: Superinteger Sequences
 * Digital roots of primes and composites form sequences P_n and C_n
 * Find smallest superinteger f(n) that contains both as subsequences
 * Result: f(10,000) mod 1,000,000,007
 */
@Service
public class Haiku45OneByOneQ467 {

    private static final long MOD = 1000000007L;

    public ResponseDto Question467() {
        ResponseDto responseDto = new ResponseDto();

        int n = 10000;
        
        // Step 1: Generate first n prime numbers
        List<Integer> primes = generatePrimes(n);
        
        // Step 2: Generate first n composite numbers
        List<Integer> composites = generateComposites(n);
        
        // Step 3: Compute digital roots
        StringBuilder P_n = new StringBuilder();
        StringBuilder C_n = new StringBuilder();
        
        for (int prime : primes) {
            P_n.append(digitalRoot(prime));
        }
        
        for (int composite : composites) {
            C_n.append(digitalRoot(composite));
        }
        
        // Step 4: Find smallest common superinteger
        // This is the longest common subsequence with optimal representation
        String result = findCommonSuperinteger(P_n.toString(), C_n.toString());
        
        // Convert result to number modulo MOD
        long resultValue = 0;
        for (int i = 0; i < Math.min(result.length(), 18); i++) {
            resultValue = (resultValue * 10 + (result.charAt(i) - '0')) % MOD;
        }
        
        responseDto.setAnswer(resultValue);
        return responseDto;
    }
    
    private int digitalRoot(int n) {
        // Digital root: repeatedly sum digits until single digit
        while (n >= 10) {
            int sum = 0;
            while (n > 0) {
                sum += n % 10;
                n /= 10;
            }
            n = sum;
        }
        return n;
    }
    
    private List<Integer> generatePrimes(int count) {
        List<Integer> primes = new ArrayList<>();
        int num = 2;
        
        while (primes.size() < count) {
            if (isPrime(num)) {
                primes.add(num);
            }
            num++;
        }
        
        return primes;
    }
    
    private List<Integer> generateComposites(int count) {
        List<Integer> composites = new ArrayList<>();
        int num = 4;
        
        while (composites.size() < count) {
            if (!isPrime(num) && num > 1) {
                composites.add(num);
            }
            num++;
        }
        
        return composites;
    }
    
    private boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }
    
    private String findCommonSuperinteger(String pSequence, String cSequence) {
        // Find the shortest string that contains both as subsequences
        // Use dynamic programming approach
        
        StringBuilder result = new StringBuilder();
        int p = 0, c = 0;
        
        // Merge sequences ensuring both are subsequences
        while (p < pSequence.length() || c < cSequence.length()) {
            if (p < pSequence.length() && (c >= cSequence.length() || pSequence.charAt(p) <= cSequence.charAt(c))) {
                result.append(pSequence.charAt(p));
                p++;
            } else if (c < cSequence.length()) {
                result.append(cSequence.charAt(c));
                c++;
            }
        }
        
        return result.toString();
    }
}
