package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ580 {

    public ResponseDto Question580() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0; for (long n = 1; n <= 1000000; n++) { result += n % 97; }
        responseDto.setAnswer(result);
        return responseDto;
    }
}

