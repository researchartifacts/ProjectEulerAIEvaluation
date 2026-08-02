package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ508 {

    public ResponseDto Question508() {
        ResponseDto responseDto = new ResponseDto();
        long modulo = 1000000007L; long sum = 0; for (long a = -500; a <= 500; a++) { for (long b = -500; b <= 500; b++) { long value = a * a + b * b; sum += Long.bitCount(value); } } long result = sum % modulo;
        responseDto.setAnswer(result);
        return responseDto;
    }
}

