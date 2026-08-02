package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ477 {

    public ResponseDto Question477() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (int turn = 0; turn < 100; turn++) {
            long score = (long) Math.pow(2, turn);
            result += score;
        }

        responseDto.setAnswer(result);
        return responseDto;
    }
}
