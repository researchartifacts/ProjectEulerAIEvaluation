package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ411 {

    public ResponseDto Question411() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (int k = 1; k <= 30; k++) {
            long n = k * k * k * k * k;
            long stations = 1;
            for (long i = 1; i <= Math.min(n, 100); i++) {
                if (n % i == 0) {
                    stations++;
                }
            }
            result += stations;
        }

        responseDto.setAnswer(result);
        return responseDto;
    }
}
