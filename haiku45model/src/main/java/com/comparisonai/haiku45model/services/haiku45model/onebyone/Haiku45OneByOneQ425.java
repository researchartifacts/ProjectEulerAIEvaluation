package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ425 {

    public ResponseDto Question425() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;
        int limit = 100000;

        boolean[] sieve = new boolean[limit + 1];
        for (int i = 2; i <= limit; i++) {
            sieve[i] = true;
        }

        for (int i = 2; i * i <= limit; i++) {
            if (sieve[i]) {
                for (int j = i * i; j <= limit; j += i) {
                    sieve[j] = false;
                }
            }
        }

        for (int i = 2; i <= limit; i++) {
            if (sieve[i] && i != 2) {
                result += i;
            }
        }

        responseDto.setAnswer(result);
        return responseDto;
    }
}
