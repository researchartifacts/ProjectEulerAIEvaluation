package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ505 {

    public ResponseDto Question505() {
        ResponseDto responseDto = new ResponseDto();
        long power60 = (1L << 60); long result = 0; long[] x = new long[100]; x[0] = 0; x[1] = 1; for (int k = 2; k < 100; k++) { x[k] = (k % 2 == 0) ? (3 * x[k/2] + 2 * x[k/4]) % power60 : (2 * x[(k-1)/2] + 3 * x[(k-1)/4]) % power60; result += x[k]; }
        responseDto.setAnswer(result);
        return responseDto;
    }
}

