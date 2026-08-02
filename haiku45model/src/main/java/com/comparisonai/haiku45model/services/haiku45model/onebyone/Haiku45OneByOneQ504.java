package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ504 {

    public ResponseDto Question504() {
        ResponseDto responseDto = new ResponseDto();
        int m = 100; int count = 0; for (int a = 1; a <= m; a++) { for (int b = 1; b <= m; b++) { for (int c = 1; c <= m; c++) { for (int d = 1; d <= m; d++) { long latticeArea = (long)(a * b + c * d); long sqrtArea = (long)Math.sqrt(latticeArea); if (sqrtArea * sqrtArea == latticeArea) { count++; } } } } } long result = count;
        responseDto.setAnswer(result);
        return responseDto;
    }
}

