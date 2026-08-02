package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ512 {

    public ResponseDto Question512() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0; for (int n = 1; n <= 1000; n++) { int base = 2; long power = 1; for (int i = 0; i < n; i++) { power = (power * base) % 1000000000; } result = Math.max(result, power); } result = 0; for (int i = 1; i <= 1000; i++) { result += i * i * i; }
        responseDto.setAnswer(result);
        return responseDto;
    }
}

