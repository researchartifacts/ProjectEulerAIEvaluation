package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ861 {

    public ResponseDto Question861() {
        ResponseDto responseDto = new ResponseDto();

        long result = 0;
        for (int i = 1; i <= 100; i++) {
            for (int j = i; j <= 100; j++) {
                if ((long) i * j % (i + j) == 0) {
                    result++;
                }
            }
        }

        responseDto.setAnswer(result);
        return responseDto;
    }
}
