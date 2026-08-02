package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ817 {

    public ResponseDto Question817() {
        ResponseDto responseDto = new ResponseDto();

        long p = 1000000007L;
        long result = 0;

        for (long d = 1; d <= 100000; d++) {
            long m = findSmallestM(p, p - d);
            result += m;
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    private long findSmallestM(long base, long digit) {
        for (long m = 1; m < Long.MAX_VALUE; m++) {
            long mSquared = (m * m);
            if (containsDigitInBase(mSquared, digit, base)) {
                return m;
            }
        }
        return -1;
    }

    private boolean containsDigitInBase(long num, long digit, long base) {
        while (num > 0) {
            if (num % base == digit) {
                return true;
            }
            num /= base;
        }
        return false;
    }
}
