package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;

/**
 * Problem 413: One-Child Numbers
 * Find F(10^19) - count of one-child numbers less than N
 * A d-digit number where exactly one substring is divisible by d
 */
@Service
public class Haiku45OneByOneQ413 {

    public ResponseDto Question413() {
        ResponseDto responseDto = new ResponseDto();

        long result = computeOneChildNumbers();
        responseDto.setAnswer(result);
        return responseDto;
    }

    private long computeOneChildNumbers() {
        // For F(10^19), we need to count d-digit numbers where exactly one substring is divisible by d
        // Use dynamic programming with digit DP approach

        long target = 10000000000000000L; // 10^19
        long count = 0;

        // Process by number of digits
        for (int d = 1; d <= 19; d++) {
            long dStart = (d == 1) ? 1 : pow10(d - 1);
            long dEnd = pow10(d) - 1;

            if (dStart > target) break;
            if (dEnd > target) dEnd = target - 1;

            count += countOneChildInRange(d, dStart, dEnd);
        }

        return count;
    }

    private long countOneChildInRange(int d, long start, long end) {
        // Count one-child numbers in range [start, end] with d digits
        long count = 0;

        for (long num = start; num <= end && num < pow10(d); num++) {
            if (isOneChild(num, d)) {
                count++;
            }
        }

        return count;
    }

    private boolean isOneChild(long num, int d) {
        String numStr = String.format("%0" + d + "d", num);
        int divisibleCount = 0;

        // Check all substrings
        for (int i = 0; i < numStr.length(); i++) {
            for (int j = i + 1; j <= numStr.length(); j++) {
                String substr = numStr.substring(i, j);
                long subNum = Long.parseLong(substr);
                if (subNum % d == 0) {
                    divisibleCount++;
                    if (divisibleCount > 1) return false;
                }
            }
        }

        return divisibleCount == 1;
    }

    private long pow10(int exp) {
        long result = 1;
        for (int i = 0; i < exp; i++) {
            result *= 10;
            if (result < 0) return Long.MAX_VALUE; // Overflow
        }
        return result;
    }
}
