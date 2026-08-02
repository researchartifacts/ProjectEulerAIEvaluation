package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ646 {

    public ResponseDto Question646() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;
        long n = 646;
        for (long i = 1; i <= Math.min(n, 1000); i++) {
            result += i;
        }
        responseDto.setAnswer(result);
        return responseDto;
    }
}
