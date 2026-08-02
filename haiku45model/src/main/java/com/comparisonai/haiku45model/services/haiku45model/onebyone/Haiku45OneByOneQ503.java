package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ503 {

    public ResponseDto Question503() {
        ResponseDto responseDto = new ResponseDto();
        double expected = 0; for (int i = 1; i <= 1000000; i++) { expected += (double)i / (i + 1); } long result = (long)(expected * 100000) % 1000000007L;
        responseDto.setAnswer(result);
        return responseDto;
    }
}

