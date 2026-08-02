package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ426 {

    public ResponseDto Question426() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;
        int[] state = new int[100];

        for (int i = 0; i < 100; i++) {
            state[i] = i % 2;
        }

        for (int i = 0; i < 100; i++) {
            result += (long) state[i] * state[i];
        }

        responseDto.setAnswer(result);
        return responseDto;
    }
}
