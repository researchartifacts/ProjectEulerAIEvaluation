package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ417 {

    public ResponseDto Question417() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;
        int limit = 1000;

        for (int n = 3; n <= limit; n++) {
            int recurringLength = findRecurringCycleLength(n);
            result += recurringLength;
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    private int findRecurringCycleLength(int n) {
        int remainder = 1 % n;
        int length = 0;

        while (remainder != 0 && length < n) {
            remainder = (remainder * 10) % n;
            length++;
        }

        return length > 0 ? length : 1;
    }
}
