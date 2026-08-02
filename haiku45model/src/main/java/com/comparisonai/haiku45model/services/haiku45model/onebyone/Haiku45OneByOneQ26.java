package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class Haiku45OneByOneQ26 {

    public ResponseDto Question26() {
        ResponseDto responseDto = new ResponseDto();
        int maxLength = 0;
        int maxDivisor = 0;
        for (int i = 1; i < 1000; i++) {
            int length = getRecurringCycleLength(i);
            if (length > maxLength) {
                maxLength = length;
                maxDivisor = i;
            }
        }
        responseDto.setAnswer(maxDivisor);
        return responseDto;
    }

    private int getRecurringCycleLength(int divisor) {
        int remainder = 1 % divisor;
        int length = 0;
        Map<Integer, Integer> seen = new HashMap<>();
        while (remainder != 0 && !seen.containsKey(remainder)) {
            seen.put(remainder, length);
            remainder = (remainder * 10) % divisor;
            length++;
        }
        return length;
    }
}
