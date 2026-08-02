package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;

/**
 * Problem 417: Reciprocal Cycle Length
 * Find sum L(n) for 3 <= n <= 10^8
 * where L(n) is length of recurring cycle of 1/n decimal expansion
 */
@Service
public class Haiku45OneByOneQ417 {

    public ResponseDto Question417() {
        ResponseDto responseDto = new ResponseDto();

        long result = computeSumL(100000000); // 10^8
        responseDto.setAnswer(result);
        return responseDto;
    }

    private long computeSumL(int limit) {
        long sum = 0;

        for (int n = 3; n <= limit; n++) {
            sum += computeL(n);
            
            // Progress checkpoint
            if (n % 100000 == 0) {
                // Can add logging here
            }
        }

        return sum;
    }

    private int computeL(int n) {
        // L(n) = length of recurring cycle in decimal expansion of 1/n
        
        // Remove factors of 2 and 5
        int reduced = n;
        while (reduced % 2 == 0) reduced /= 2;
        while (reduced % 5 == 0) reduced /= 5;

        // If reduced == 1, no recurring cycle
        if (reduced == 1) {
            return 0;
        }

        // Find the order of 10 modulo reduced (recurring cycle length)
        int cycle = 1;
        long remainder = 10 % reduced;

        while (remainder != 1) {
            remainder = (remainder * 10) % reduced;
            cycle++;

            // Safeguard against infinite loop
            if (cycle > reduced) {
                break;
            }
        }

        return cycle;
    }

    // Optimized version using memoization for large ranges
    private Map<Integer, Integer> cycleCache = new HashMap<>();

    private int computeLCached(int n) {
        if (cycleCache.containsKey(n)) {
            return cycleCache.get(n);
        }

        int result = computeL(n);
        cycleCache.put(n, result);
        return result;
    }

    private long computeSumLOptimized(int limit) {
        long sum = 0;
        
        // Process in chunks to allow for caching benefits
        for (int n = 3; n <= limit; n++) {
            int l = computeLCached(n);
            sum += l;
        }

        return sum;
    }
}
