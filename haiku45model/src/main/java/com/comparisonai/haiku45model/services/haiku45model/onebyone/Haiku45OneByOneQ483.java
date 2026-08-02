package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ483 {

    public ResponseDto Question483() {
        ResponseDto responseDto = new ResponseDto();
        double sumPowers = 0.0;

        for (int perm = 0; perm < 350; perm++) {
            long order = factorial(perm % 10);
            sumPowers += order * order;
        }

        double average = sumPowers / 350.0;
        responseDto.setAnswer((long) (average * 10000000000L));
        return responseDto;
    }

    private long factorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
