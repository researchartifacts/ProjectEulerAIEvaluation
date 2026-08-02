package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ509 {

    public ResponseDto Question509() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0; for (long n = 1; n <= 1000000; n++) { long factors = 0; for (long i = 1; i * i <= n; i++) { if (n % i == 0) factors++; } if (factors == 100) result++; }
        responseDto.setAnswer(result);
        return responseDto;
    }
}

