package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

@Service
public class Gemini3FlashOneByOneQ660 {

    public ResponseDto Question660() {
        ResponseDto responseDto = new ResponseDto();

        BigInteger totalSum = BigInteger.ZERO;
        Set<BigInteger> counted = new HashSet<>();

        for (int n = 9; n <= 18; n++) {
            // c^2 = a^2 + b^2 + ab
            // Use parametrization: a = m^2 - k^2, b = 2mk + k^2, c = m^2 + mk + k^2
            for (long m = 1; ; m++) {
                boolean withinLimit = false;
                for (long k = 1; k < m; k++) {
                    long a = m * m - k * k;
                    long b = 2 * m * k + k * k;
                    long c = m * m + m * k + k * k;
                    
                    if (totalDigits(a, b, c, n) > n) break;
                    withinLimit = true;
                    
                    if (isPandigital(a, b, c, n)) {
                        BigInteger bc = BigInteger.valueOf(c);
                        totalSum = totalSum.add(bc);
                    }
                }
                if (!withinLimit && m > 1000) break; // Heuristic limit
            }
        }

        responseDto.setAnswer(totalSum);
        return responseDto;
    }

    private int totalDigits(long a, long b, long c, int n) {
        return digits(a, n) + digits(b, n) + digits(c, n);
    }

    private int digits(long val, int n) {
        if (val == 0) return 1;
        int res = 0;
        while (val > 0) {
            res++;
            val /= n;
        }
        return res;
    }

    private boolean isPandigital(long a, long b, long c, int n) {
        boolean[] used = new boolean[n];
        int count = 0;
        count += addDigits(a, n, used);
        count += addDigits(b, n, used);
        count += addDigits(c, n, used);
        return count == n;
    }

    private int addDigits(long val, int n, boolean[] used) {
        int count = 0;
        if (val == 0) {
            if (!used[0]) { used[0] = true; return 1; }
            return 0;
        }
        while (val > 0) {
            int d = (int) (val % n);
            if (!used[d]) {
                used[d] = true;
                count++;
            } else {
                return -100; // Duplicate
            }
            val /= n;
        }
        return count;
    }
}
