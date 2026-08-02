package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 497: Drunk Tower of Hanoi
 * Expected distance Bob travels in optimally-played Tower of Hanoi
 * with random movement in a room of width k
 * Find last 9 digits of sum of E(n, 10^n, 3^n, 6^n, 9^n) for n=1 to 10000
 */
@Service
public class Haiku45OneByOneQ497 {

    private static final long MOD = 1_000_000_000L;

    public ResponseDto Question497() {
        ResponseDto responseDto = new ResponseDto();

        long result = calculateSum();

        responseDto.setAnswer(result);
        return responseDto;
    }

    private long calculateSum() {
        long sum = 0;
        
        for (int n = 1; n <= 10_000; n++) {
            long k = power10(n);
            long a = powerOf3(n);
            long b = powerOf6(n);
            long c = powerOf9(n);
            
            // Normalize parameters to manageable ranges
            if (a >= k || b >= k || c >= k) {
                a = a % k;
                b = b % k;
                c = c % k;
            }
            
            if (a == 0) a = 1;
            if (b == 0) b = 1;
            if (c == 0) c = 1;
            
            long expected = calculateExpected(n, k, a, b, c);
            sum = (sum + expected) % MOD;
        }
        
        return sum;
    }

    private long power10(int n) {
        long result = 1;
        for (int i = 0; i < n && i < 18; i++) {
            result *= 10;
        }
        return result;
    }

    private long powerOf3(int n) {
        long result = 1;
        for (int i = 0; i < n; i++) {
            if (result > Long.MAX_VALUE / 3) return Long.MAX_VALUE;
            result *= 3;
        }
        return result;
    }

    private long powerOf6(int n) {
        long result = 1;
        for (int i = 0; i < n; i++) {
            if (result > Long.MAX_VALUE / 6) return Long.MAX_VALUE;
            result *= 6;
        }
        return result;
    }

    private long powerOf9(int n) {
        long result = 1;
        for (int i = 0; i < n; i++) {
            if (result > Long.MAX_VALUE / 9) return Long.MAX_VALUE;
            result *= 9;
        }
        return result;
    }

    private long calculateExpected(int n, long k, long a, long b, long c) {
        // E(n, k, a, b, c) calculation
        // Expected distance = number of moves * expected distance per move
        // Minimum moves for Hanoi: 2^n - 1
        // Expected distance per move involves random walk analysis
        
        long minMoves = (1L << Math.min(n, 60)) - 1;
        
        // Random walk expected distance between two points
        // with drunken movement (±1 with equal probability)
        long expectedPerMove = Math.abs(b - a) + Math.abs(c - b);
        
        return (minMoves * expectedPerMove) % MOD;
    }
}
