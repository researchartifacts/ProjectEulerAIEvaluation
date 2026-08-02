package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 442: Eleven-free integers
 * Find the E(10^18)th eleven-free integer
 * An integer is eleven-free if it doesn't contain powers of 11 as substrings (except 1)
 * Powers of 11: 11, 121, 1331, 14641, ...
 */
@Service
public class Haiku45OneByOneQ442 {

    public ResponseDto Question442() {
        ResponseDto responseDto = new ResponseDto();

        long targetIndex = 1_000_000_000_000_000_000L; // 10^18
        long count = 0;
        long num = 1;

        // Pre-compute string representations of powers of 11
        String[] powerOf11 = generatePowersOf11();

        // Count eleven-free integers until we reach the target index
        while (count < targetIndex) {
            if (isElevenFree(num, powerOf11)) {
                count++;
                if (count == targetIndex) {
                    responseDto.setAnswer(num);
                    return responseDto;
                }
            }
            num++;

            // Progress indicator
            if (count % 10_000_000 == 0 && count > 0) {
                System.out.println("Progress: Found " + count + " eleven-free integers, current num: " + num);
            }
        }

        responseDto.setAnswer(num);
        return responseDto;
    }

    /**
     * Generate string representations of powers of 11
     */
    private String[] generatePowersOf11() {
        // Powers of 11 that fit in reasonable string length
        return new String[] {
            "11",      // 11^1
            "121",     // 11^2
            "1331",    // 11^3
            "14641",   // 11^4
            "161051",  // 11^5
            "1771561", // 11^6
            "19487171" // 11^7
        };
    }

    /**
     * Check if a number is eleven-free
     */
    private boolean isElevenFree(long num, String[] powersOf11) {
        String numStr = String.valueOf(num);

        // Check if any power of 11 (except 1) appears as substring
        for (String power : powersOf11) {
            if (numStr.contains(power)) {
                return false;
            }
        }

        return true;
    }
}
