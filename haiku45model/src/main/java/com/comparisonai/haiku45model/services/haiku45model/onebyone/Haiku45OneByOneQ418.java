package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ418 {

    public ResponseDto Question418() {
        ResponseDto responseDto = new ResponseDto();
        double result = 0;
        long factorial = 1;
        for (int i = 1; i <= 10; i++) {
            factorial *= i;
        }

        long divisorCount = 0;
        for (long i = 1; i * i <= factorial; i++) {
            if (factorial % i == 0) {
                divisorCount += (i == factorial / i) ? 1 : 2;
            }
        }

        responseDto.setAnswer(divisorCount);
        return responseDto;
    }
}
