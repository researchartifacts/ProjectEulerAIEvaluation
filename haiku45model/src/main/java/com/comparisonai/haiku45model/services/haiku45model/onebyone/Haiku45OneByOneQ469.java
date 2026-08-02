package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ469 {

    public ResponseDto Question469() {
        ResponseDto responseDto = new ResponseDto();
        double chairs = 1000;
        double expected = chairs / 2.0;

        responseDto.setAnswer((long) (expected * 100000000000000L));
        return responseDto;
    }
}
