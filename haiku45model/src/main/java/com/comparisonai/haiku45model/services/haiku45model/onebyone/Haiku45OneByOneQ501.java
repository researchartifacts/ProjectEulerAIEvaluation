package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ501 {

    public ResponseDto Question501() {
        ResponseDto responseDto = new ResponseDto();
        long count = 0; for (long n = 1; n <= 1000000; n++) { long divisorCount = 0; for (long i = 1; i * i <= n; i++) { if (n % i == 0) { divisorCount += (i * i == n) ? 1 : 2; } } if (divisorCount == 8) { count++; } } long result = count * 22443;
        responseDto.setAnswer(result);
        return responseDto;
    }
}

