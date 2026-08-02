package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 44
 */
@Service
public class Haiku45OneByOneQ44 {

    public ResponseDto Question44() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Find pair of pentagonal numbers where sum and diff are both pentagonal
        // Minimize |Pk - Pj|
        // Generated logic to solve the problem:
        
        java.util.Set<Long> pentagonals = new java.util.HashSet<>();
        java.util.List<Long> pentList = new java.util.ArrayList<>();
        
        // Generate pentagonal numbers up to a reasonable limit
        for (long n = 1; n <= 10000; n++) {
            long pn = n * (3 * n - 1) / 2;
            pentagonals.add(pn);
            pentList.add(pn);
        }
        
        long minDifference = Long.MAX_VALUE;
        
        // Check all pairs
        for (int i = 0; i < pentList.size(); i++) {
            for (int j = i + 1; j < pentList.size(); j++) {
                long pi = pentList.get(i);
                long pj = pentList.get(j);
                
                long sum = pi + pj;
                long diff = pj - pi;
                
                if (pentagonals.contains(sum) && pentagonals.contains(diff)) {
                    if (diff < minDifference) {
                        minDifference = diff;
                    }
                }
            }
        }
        
        Object result = minDifference;
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
