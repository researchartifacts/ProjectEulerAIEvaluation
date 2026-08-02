package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ544 {

    public ResponseDto Question544() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0; long[] fib = new long[100]; fib[0] = 1; fib[1] = 1; for (int j = 2; j < 100; j++) { fib[j] = (fib[j-1] + fib[j-2]) % 1000000007; result += fib[j]; }
        responseDto.setAnswer(result);
        return responseDto;
    }
}

