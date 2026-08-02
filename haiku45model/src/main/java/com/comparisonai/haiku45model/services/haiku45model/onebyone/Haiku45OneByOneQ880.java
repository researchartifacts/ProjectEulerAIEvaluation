package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ880 {

    public ResponseDto Question880() {
        ResponseDto responseDto = new ResponseDto();

        long result = 0;
        for (int i = 1; i <= 1000; i++) {
            result += sumOfDigits(i);
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    private int sumOfDigits(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
