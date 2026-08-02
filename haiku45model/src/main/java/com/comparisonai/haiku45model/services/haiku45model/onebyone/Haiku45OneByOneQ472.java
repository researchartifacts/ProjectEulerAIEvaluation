package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ472 {

    public ResponseDto Question472() {
        ResponseDto responseDto = new ResponseDto();
        long MOD = 100000000L;
        long result = 0;

        for (int n = 1; n <= 100; n++) {
            long maxOccupants = (long) Math.sqrt(n);
            result = (result + maxOccupants) % MOD;
        }

        responseDto.setAnswer(result);
        return responseDto;
    }
}
