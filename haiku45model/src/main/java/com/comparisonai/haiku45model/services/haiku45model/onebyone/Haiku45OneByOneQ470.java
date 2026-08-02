package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ470 {

    public ResponseDto Question470() {
        ResponseDto responseDto = new ResponseDto();
        double totalProfit = 0.0;

        for (int round = 1; round <= 20; round++) {
            double profit = Math.pow(2, round) - 1;
            totalProfit += profit;
        }

        responseDto.setAnswer((long) Math.round(totalProfit));
        return responseDto;
    }
}
