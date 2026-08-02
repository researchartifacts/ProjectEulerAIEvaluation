package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ481 {

    public ResponseDto Question481() {
        ResponseDto responseDto = new ResponseDto();
        double expectedDishes = 0.0;

        for (int chef = 0; chef < 14; chef++) {
            long fibSkill = fibonacci(chef + 1);
            expectedDishes += fibSkill / 100.0;
        }

        responseDto.setAnswer((long) (expectedDishes * 100000000));
        return responseDto;
    }

    private long fibonacci(int n) {
        if (n <= 1) return n;
        long a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            long temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }
}
