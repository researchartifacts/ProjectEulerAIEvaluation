package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 45
 */
@Service
public class Haiku45OneByOneQ45 {

    public ResponseDto Question45() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Find next number that is triangle, pentagonal, and hexagonal after 40755
        // T_n = n(n+1)/2, P_n = n(3n-1)/2, H_n = n(2n-1)
        // Generated logic to solve the problem:
        
        java.util.Set<Long> pentagonals = new java.util.HashSet<>();
        java.util.Set<Long> hexagonals = new java.util.HashSet<>();
        
        // Generate pentagonal and hexagonal numbers
        for (long n = 1; n <= 100000; n++) {
            pentagonals.add(n * (3 * n - 1) / 2);
            hexagonals.add(n * (2 * n - 1));
        }
        
        long result = 0;
        // Iterate through triangle numbers starting from 40755
        for (long n = 286; n <= 1000000; n++) {
            long tn = n * (n + 1) / 2;
            if (tn > 40755 && pentagonals.contains(tn) && hexagonals.contains(tn)) {
                result = tn;
                break;
            }
        }
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
