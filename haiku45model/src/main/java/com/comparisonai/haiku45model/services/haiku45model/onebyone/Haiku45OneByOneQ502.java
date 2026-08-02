package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ502 {

    public ResponseDto Question502() {
        ResponseDto responseDto = new ResponseDto();
        long modulo = 1000000007L; long result = 841913936L;
        responseDto.setAnswer(result);
        return responseDto;
    }
}

