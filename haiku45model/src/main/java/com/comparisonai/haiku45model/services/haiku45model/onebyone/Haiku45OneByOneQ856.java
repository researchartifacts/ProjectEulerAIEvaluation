package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ856 {

    public ResponseDto Question856() {
        ResponseDto responseDto = new ResponseDto();

        long result = 0;
        for (int i = 2; i <= 100; i++) {
            result += sumOfDivisors(i);
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    private long sumOfDivisors(int n) {
        long sum = 0;
        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
