package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ453 {

    public ResponseDto Question453() {
        ResponseDto responseDto = new ResponseDto();
        long MOD = 135707531L;
        long result = 0;

        for (int x1 = 0; x1 <= 100; x1++) {
            for (int y1 = 0; y1 <= 100; y1++) {
                for (int x2 = x1 + 1; x2 <= 100; x2++) {
                    for (int y2 = y1 + 1; y2 <= 100; y2++) {
                        result = (result + 1) % MOD;
                    }
                }
            }
        }

        responseDto.setAnswer(result);
        return responseDto;
    }
}
