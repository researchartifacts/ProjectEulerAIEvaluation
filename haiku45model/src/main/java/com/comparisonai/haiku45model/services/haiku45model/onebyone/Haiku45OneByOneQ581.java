package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ581 {

    public ResponseDto Question581() {
        ResponseDto responseDto = new ResponseDto();
        long sum = 0; for (int a = 1; a <= 1000; a++) { for (int b = 1; b <= 1000; b++) { long c = a * a + b * b; long sqrtC = (long)Math.sqrt(c); if (sqrtC * sqrtC == c && sqrtC > 0) { sum++; } } } long result = sum;
        responseDto.setAnswer(result);
        return responseDto;
    }
}

