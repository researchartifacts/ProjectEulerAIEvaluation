package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;

/**
 * Problem 414: Kaprekar Routine in Various Bases
 * Find sum of S(6k+3) for 2 <= k <= 300, last 18 digits
 * where S(b) is sum of iteration counts for Kaprekar routine in base b
 */
@Service
public class Haiku45OneByOneQ414 {

    private static final long MOD = 1000000000000000000L; // 10^18

    public ResponseDto Question414() {
        ResponseDto responseDto = new ResponseDto();

        long result = 0;
        for (int k = 2; k <= 300; k++) {
            int base = 6 * k + 3;
            long s = computeS(base);
            result = (result + s) % MOD;
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    private long computeS(int base) {
        // For base b, compute S(b) = sum of iterations to reach Kaprekar constant
        // for all numbers from 1 to b^5 - 1

        long kaprekarConstant = findKaprekarConstant(base);
        long sum = 0;

        long limit = 1;
        for (int i = 0; i < 5; i++) {
            limit *= base;
        }

        // Compute iterations for each number
        for (long i = 1; i < limit; i++) {
            if (i % 10000 == 0 && i > 0) {
                // Progress checkpoint for large ranges
            }

            int iterations = countIterations(i, kaprekarConstant, base);
            sum = (sum + iterations) % MOD;
        }

        return sum;
    }

    private long findKaprekarConstant(int base) {
        // Find Kaprekar constant for given base with 5 digits
        // Start with a typical number and iterate

        long[] number = new long[5];
        for (int i = 0; i < 5; i++) {
            number[i] = 1;
        }

        Set<Long> seen = new HashSet<>();
        while (true) {
            long next = kaprekarStep(number, base);
            if (seen.contains(next)) {
                return next;
            }
            seen.add(next);
            number = toDigits(next, base, 5);
            if (seen.size() > 1000) break; // Safeguard
        }

        return toNumber(number, base);
    }

    private long kaprekarStep(long[] digits, int base) {
        long[] sorted = digits.clone();
        Arrays.sort(sorted);

        long ascending = toNumber(sorted, base);
        long descending = 0;
        for (int i = sorted.length - 1; i >= 0; i--) {
            descending = descending * base + sorted[i];
        }

        return descending - ascending;
    }

    private int countIterations(long num, long kaprekarConstant, int base) {
        long[] digits = toDigits(num, base, 5);
        int iterations = 0;

        while (true) {
            long current = toNumber(digits, base);
            if (current == kaprekarConstant) return iterations;
            if (isAllSame(digits)) return 0;

            long next = kaprekarStep(digits, base);
            digits = toDigits(next, base, 5);
            iterations++;

            if (iterations > 100) break; // Safeguard
        }

        return iterations;
    }

    private boolean isAllSame(long[] digits) {
        for (int i = 1; i < digits.length; i++) {
            if (digits[i] != digits[0]) return false;
        }
        return true;
    }

    private long[] toDigits(long num, int base, int length) {
        long[] digits = new long[length];
        for (int i = length - 1; i >= 0; i--) {
            digits[i] = num % base;
            num /= base;
        }
        return digits;
    }

    private long toNumber(long[] digits, int base) {
        long result = 0;
        for (long digit : digits) {
            result = result * base + digit;
        }
        return result;
    }
}
