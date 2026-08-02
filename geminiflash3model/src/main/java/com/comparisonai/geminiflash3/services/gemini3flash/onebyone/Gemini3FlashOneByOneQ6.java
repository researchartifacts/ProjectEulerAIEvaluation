package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ6 {

    public ResponseDto Question6() {
        ResponseDto responseDto = new ResponseDto();
        long n = 100;
        long sumOfSquares = n * (n + 1) * (2 * n + 1) / 6;
        long sum = n * (n + 1) / 2;
        long squareOfSum = sum * sum;
        responseDto.setAnswer(squareOfSum - sumOfSquares);
        return responseDto;
    }
}
