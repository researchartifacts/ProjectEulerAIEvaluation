package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ879 {

    public ResponseDto Question879() {
        ResponseDto responseDto = new ResponseDto();

        long result = 0;
        for (int i = 1; i <= 100; i++) {
            for (int j = i + 1; j <= 100; j++) {
                result += (long) i * j;
            }
        }

        responseDto.setAnswer(result);
        return responseDto;
    }
}
