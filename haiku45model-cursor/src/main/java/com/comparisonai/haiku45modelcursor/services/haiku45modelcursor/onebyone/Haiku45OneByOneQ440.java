package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 440 - Tiling Board with Blocks and Digits
 * 
 * Tile a 1×n board with:
 * - 1×2 blocks (dominoes)
 * - 1×1 blocks with single decimal digit (0-9) on top
 * 
 * T(n) = number of ways to tile a board of length n
 * S(L) = sum of gcd(T(c^a), T(c^b)) for 1 <= a,b,c <= L
 * 
 * Find S(2000) mod 987898789
 */
@Service
public class Haiku45OneByOneQ440 {

    private static final long MOD = 987_898_789L;

    public ResponseDto Question440() {
        ResponseDto responseDto = new ResponseDto();

        int L = 2000;
        long result = 0;

        // First, calculate T(n) for n up to some limit
        // T(n) = number of ways to tile length n board
        // T(1) = 10 (one 1×1 block with any digit)
        // T(2) = 101 (either two 1×1 blocks with any digits, or one 1×2 domino)
        
        // Recurrence: T(n) = 10*T(n-1) + T(n-2)
        // Because at position n, we can place:
        // - A 1×1 block with any of 10 digits (giving 10*T(n-1))
        // - A 1×2 domino (giving T(n-2))
        
        // Calculate T(n) values
        java.util.Map<Long, Long> tValues = new java.util.HashMap<>();
        calculateTValues(tValues, L);
        
        // Calculate S(L) = sum of gcd(T(c^a), T(c^b)) for 1 <= a,b,c <= L
        result = calculateS(L, tValues);

        responseDto.setAnswer(result);
        return responseDto;
    }

    private void calculateTValues(java.util.Map<Long, Long> tValues, int L) {
        // T(n) = 10*T(n-1) + T(n-2)
        // T(1) = 10
        // T(2) = 101
        
        tValues.put(1L, 10L);
        tValues.put(2L, 101L);
        
        // Calculate T(c^a) for all c from 1 to L and powers up to L
        java.util.Set<Long> needed = new java.util.HashSet<>();
        
        for (int c = 1; c <= L; c++) {
            long power = c;
            for (int a = 1; a <= L && power <= 1_000_000_000_000L; a++) {
                needed.add(power);
                if (a < L) {
                    power *= c;
                    if (power > 1_000_000_000_000L) break;
                }
            }
        }
        
        // Calculate T(n) for all needed values
        for (long n : needed) {
            if (!tValues.containsKey(n)) {
                calculateT(n, tValues);
            }
        }
    }

    private long calculateT(long n, java.util.Map<Long, Long> memo) {
        if (n == 1) return 10;
        if (n == 2) return 101;
        
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        
        // T(n) = 10*T(n-1) + T(n-2)
        long tn1 = calculateT(n - 1, memo);
        long tn2 = calculateT(n - 2, memo);
        
        long tn = (10 * tn1 + tn2) % MOD;
        memo.put(n, tn);
        
        return tn;
    }

    private long calculateS(int L, java.util.Map<Long, Long> tValues) {
        long result = 0;
        
        // S(L) = sum of gcd(T(c^a), T(c^b)) for 1 <= a,b,c <= L
        
        for (int c = 1; c <= L; c++) {
            java.util.List<Long> powers = getPowers(c, L);
            
            for (long ca : powers) {
                for (long cb : powers) {
                    if (!tValues.containsKey(ca) || !tValues.containsKey(cb)) {
                        continue;
                    }
                    
                    long tca = tValues.get(ca);
                    long tcb = tValues.get(cb);
                    
                    long gcdVal = gcd(tca, tcb);
                    result = (result + gcdVal) % MOD;
                }
            }
        }
        
        return result;
    }

    private java.util.List<Long> getPowers(int c, int L) {
        java.util.List<Long> powers = new java.util.ArrayList<>();
        
        long power = c;
        for (int a = 1; a <= L && power <= Long.MAX_VALUE / c; a++) {
            powers.add(power);
            power *= c;
        }
        
        return powers;
    }

    private long gcd(long a, long b) {
        a = a % MOD;
        b = b % MOD;
        
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        
        return a;
    }
}
