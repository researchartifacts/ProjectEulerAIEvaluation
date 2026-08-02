package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ2 {

    public ResponseDto Question2() {
        ResponseDto responseDto = new ResponseDto();
        long sum = 0;
        long a = 1, b = 2;
        while (b <= 4000000) {
            if (b % 2 == 0) {
                sum += b;
            }
            long temp = a + b;
            a = b;
            b = temp;
        }
        responseDto.setAnswer(sum);
        return responseDto;
    }
}
