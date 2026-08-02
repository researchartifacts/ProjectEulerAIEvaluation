package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ14 {

    public ResponseDto Question14() {
        ResponseDto responseDto = new ResponseDto();
        long maxLength = 0;
        long numberWithMaxLength = 0;
        for (long i = 1; i < 1000000; i++) {
            long length = collatzLength(i);
            if (length > maxLength) {
                maxLength = length;
                numberWithMaxLength = i;
            }
        }
        responseDto.setAnswer(numberWithMaxLength);
        return responseDto;
    }

    private long collatzLength(long n) {
        long length = 1;
        while (n != 1) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n = 3 * n + 1;
            }
            length++;
        }
        return length;
    }
}
