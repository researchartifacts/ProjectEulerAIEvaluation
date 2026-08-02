package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ412 {

    public ResponseDto Question412() {
        ResponseDto responseDto = new ResponseDto();
        long MOD = 76543217L;
        long result = 0;
        int gridSize = 100;

        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                if ((i + j) % 2 == 0) {
                    result++;
                }
            }
        }

        responseDto.setAnswer(result % MOD);
        return responseDto;
    }
}
