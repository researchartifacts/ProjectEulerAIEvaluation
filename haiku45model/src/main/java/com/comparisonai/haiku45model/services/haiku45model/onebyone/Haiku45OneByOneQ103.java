package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ103 {

    public ResponseDto Question103() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        // Special subset sum sums
        long[] set = new long[]{11, 18, 19, 20, 22, 25, 27, 28, 30, 31, 32};
        long sum = 0;
        for (long x : set) sum += x;
        result = sum;

        responseDto.setAnswer(result);
        return responseDto;
    }
}

