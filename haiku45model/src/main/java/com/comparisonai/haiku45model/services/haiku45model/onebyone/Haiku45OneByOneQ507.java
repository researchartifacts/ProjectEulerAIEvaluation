package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ507 {

    public ResponseDto Question507() {
        ResponseDto responseDto = new ResponseDto();
        long mod = 10000000L; long t0 = 0, t1 = 0, t2 = 1; long sum = 0; for (int n = 1; n <= 20000000; n++) { long next = (t0 + t1 + t2) % mod; t0 = t1; t1 = t2; t2 = next; if (n % 1000000 == 0) { sum += t2; } } long result = sum;
        responseDto.setAnswer(result);
        return responseDto;
    }
}

