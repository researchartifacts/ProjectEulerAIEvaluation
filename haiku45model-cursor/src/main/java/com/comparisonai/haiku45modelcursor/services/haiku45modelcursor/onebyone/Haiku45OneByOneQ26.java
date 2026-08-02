package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.Set;

/**
 * Problem 26
 */
@Service
public class Haiku45OneByOneQ26 {

    public ResponseDto Question26() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Find d < 1000 for which 1/d has longest recurring cycle
        // Generated logic to solve the problem:
        int maxCycleLength = 0;
        int resultD = 0;
        
        for (int d = 2; d < 1000; d++) {
            int cycleLength = getRecurringCycleLength(d);
            if (cycleLength > maxCycleLength) {
                maxCycleLength = cycleLength;
                resultD = d;
            }
        }
        
        Object result = resultD;
        
        responseDto.setAnswer(result);
        return responseDto;
    }
    
    private int getRecurringCycleLength(int d) {
        Set<Integer> seenRemainders = new HashSet<>();
        int remainder = 1;
        int cycleLength = 0;
        
        while (remainder != 0 && !seenRemainders.contains(remainder)) {
            seenRemainders.add(remainder);
            remainder = (remainder * 10) % d;
            cycleLength++;
        }
        
        return remainder == 0 ? 0 : cycleLength;
    }
}
