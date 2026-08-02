package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ415 {

    public ResponseDto Question415() {
        ResponseDto responseDto = new ResponseDto();
        long MOD = 100000000L;
        long result = 0;
        int limit = 100;

        for (int x1 = 0; x1 <= limit; x1++) {
            for (int y1 = 0; y1 <= limit; y1++) {
                for (int x2 = x1 + 1; x2 <= limit; x2++) {
                    for (int y2 = y1 + 1; y2 <= limit; y2++) {
                        result++;
                    }
                }
            }
        }

        responseDto.setAnswer(result % MOD);
        return responseDto;
    }
}
