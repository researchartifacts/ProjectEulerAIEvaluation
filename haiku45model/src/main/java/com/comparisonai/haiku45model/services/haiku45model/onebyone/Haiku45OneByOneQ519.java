package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ519 {

    public ResponseDto Question519() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0; long[] coins = {1, 2, 5, 10}; for (int amount = 1; amount <= 1000; amount++) { long ways = 0; for (long c1 = 0; c1 * 1 <= amount; c1++) { for (long c2 = 0; c2 * 2 <= amount - c1; c2++) { for (long c5 = 0; c5 * 5 <= amount - c1 - c2 * 2; c5++) { long c10 = (amount - c1 - c2 * 2 - c5 * 5) / 10; if (c10 >= 0) ways++; } } } result += ways; }
        responseDto.setAnswer(result);
        return responseDto;
    }
}

