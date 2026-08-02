package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ435 {

    public ResponseDto Question435() {
        ResponseDto responseDto = new ResponseDto();
        long MOD = 1307674368000L;
        long result = 0;

        for (int x = 0; x <= 100; x++) {
            long fibProduct = 0;
            long fib1 = 0, fib2 = 1;
            for (int i = 0; i < 100; i++) {
                fibProduct += fib1;
                long temp = fib1 + fib2;
                fib1 = fib2;
                fib2 = temp;
            }
            result = (result + fibProduct) % MOD;
        }

        responseDto.setAnswer(result);
        return responseDto;
    }
}
