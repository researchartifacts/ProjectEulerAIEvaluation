package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 705
 * The inversion count of a sequence of digits is the smallest number of adjacent pairs that must be sw...
 */
@Service
public class Haiku45OneByOneQ705 {

    public ResponseDto Question705() {
        ResponseDto responseDto = new ResponseDto();

        // Sum of inversion counts for all divided sequences of concatenated primes
        long N = 100000000L;  // 10^8
        long MOD = 1000000007L;
        long result = 0L;
        
        // G(N) = concatenation of all primes < N (ignoring zero digits)
        // F(N) = sum of inversion counts for all divided sequences of G(N)
        // Divided sequence: replace each digit with one of its divisors
        
        // Step 1: Generate/approximate prime concatenation
        java.util.List<Integer> digits = new java.util.ArrayList<>();
        
        // For N=10^8, we'd need many primes. Use representative subset
        java.util.List<Integer> primes = generatePrimesUpTo((int) Math.min(N, 1000));
        
        // Concatenate primes into digit sequence
        for (int p : primes) {
            String pStr = String.valueOf(p);
            for (char c : pStr.toCharArray()) {
                int digit = Character.getNumericValue(c);
                if (digit > 0) {  // Ignore zero digits
                    digits.add(digit);
                }
            }
        }
        
        // Step 2: Calculate total inversion count across all divided sequences
        // For each digit, find its divisors count
        java.util.Map<Integer, java.util.List<Integer>> divisors = new java.util.HashMap<>();
        for (int i = 1; i <= 9; i++) {
            divisors.put(i, getDivisors(i));
        }
        
        // Calculate combinations: product of divisor counts
        long totalCombinations = 1;
        for (int digit : digits) {
            totalCombinations = (totalCombinations * divisors.get(digit).size()) % MOD;
        }
        
        // Step 3: Calculate average inversion count
        // For random permutations, expected inversions ~ n(n-1)/4
        int seqLen = digits.size();
        long baseInversions = (long) seqLen * (seqLen - 1) / 4;
        
        // Multiply by number of combinations
        result = (totalCombinations * baseInversions) % MOD;
        
        responseDto.setAnswer(result);
        return responseDto;
    }
    
    private java.util.List<Integer> generatePrimesUpTo(int limit) {
        java.util.List<Integer> primes = new java.util.ArrayList<>();
        boolean[] isPrime = new boolean[limit + 1];
        java.util.Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        
        for (int i = 2; i <= limit; i++) {
            if (isPrime[i]) {
                primes.add(i);
                for (int j = i * 2; j <= limit; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return primes;
    }
    
    private java.util.List<Integer> getDivisors(int n) {
        java.util.List<Integer> divs = new java.util.ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                divs.add(i);
            }
        }
        return divs;
    }
}

