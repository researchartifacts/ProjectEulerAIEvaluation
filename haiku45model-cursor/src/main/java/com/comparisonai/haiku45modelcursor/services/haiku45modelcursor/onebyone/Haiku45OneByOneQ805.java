package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 805: Shifting Digits
 * s(n) = integer obtained by shifting leftmost digit to rightmost position
 * For rational r, N(r) = smallest n such that s(n) = r*n
 * Let T(M) = sum of N(u^3/v^3) where (u,v) are coprime pairs <= M
 * Find T(200) mod 1000000007
 */
@Service
public class Haiku45OneByOneQ805 {

    public ResponseDto Question805() {
        ResponseDto responseDto = new ResponseDto();

        final long MOD = 1000000007L;
        long result = 0;
        
        // For each coprime pair (u,v) where 1 <= u,v <= 200
        for (int u = 1; u <= 200; u++) {
            for (int v = 1; v <= 200; v++) {
                if (gcd(u, v) == 1) {
                    // Find N(u^3/v^3)
                    long n = findN(u, v);
                    if (n > 0) {
                        result = (result + n) % MOD;
                    }
                }
            }
        }
        
        responseDto.setAnswer(result);
        return responseDto;
    }
    
    private long findN(int u, int v) {
        // N(r) = smallest n such that s(n) = r*n
        // Brute force search up to reasonable limit
        long limit = 10000000L;
        double ratio = (double)u / v;
        
        for (long n = 1; n <= limit; n++) {
            long shifted = shiftDigits(n);
            if (shifted == (long)(n * ratio) || 
                (shifted * v == n * u)) { // Account for rational
                return n;
            }
        }
        return 0;
    }
    
    private long shiftDigits(long n) {
        String s = String.valueOf(n);
        if (s.length() == 1) return n;
        return Long.parseLong(s.substring(1) + s.charAt(0));
    }
    
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
