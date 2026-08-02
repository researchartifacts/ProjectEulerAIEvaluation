package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ594 {

    public ResponseDto Question594() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0; for (int n = 2; n <= 100000; n++) { boolean isPrime = true; if (n < 2) isPrime = false; else for (int i = 2; i * i <= n; i++) { if (n % i == 0) { isPrime = false; break; } } if (isPrime) result += n; }
        responseDto.setAnswer(result);
        return responseDto;
    }
}

