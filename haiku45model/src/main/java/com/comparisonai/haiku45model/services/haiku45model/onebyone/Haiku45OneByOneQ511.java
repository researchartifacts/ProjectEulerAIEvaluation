package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ511 {

    public ResponseDto Question511() {
        ResponseDto responseDto = new ResponseDto();
        long sum = 0; for (long n = 1; n <= 100000; n++) { long odd_divisors = 0; for (long i = 1; i * i <= n; i++) { if (n % i == 0) { if (i % 2 != 0) odd_divisors++; if (i != n/i && (n/i) % 2 != 0) odd_divisors++; } } sum += n * odd_divisors; } long result = sum;
        responseDto.setAnswer(result);
        return responseDto;
    }
}

