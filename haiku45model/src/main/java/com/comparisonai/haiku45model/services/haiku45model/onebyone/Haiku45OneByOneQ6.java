package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ6 {

    public ResponseDto Question6() {
        ResponseDto responseDto = new ResponseDto();
        long sumOfSquares = 0;
        long sum = 0;
        for (int i = 1; i <= 100; i++) {
            sumOfSquares += i * i;
            sum += i;
        }
        long squareOfSum = sum * sum;
        long difference = squareOfSum - sumOfSquares;
        responseDto.setAnswer(difference);
        return responseDto;
    }
}
