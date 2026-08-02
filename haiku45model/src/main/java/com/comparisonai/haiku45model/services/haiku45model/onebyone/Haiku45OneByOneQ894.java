package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ894 {

    public ResponseDto Question894() {
        ResponseDto responseDto = new ResponseDto();

        long result = 0;
        for (int i = 1; i <= 1000; i++) {
            result += sumOfProperDivisors(i);
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    private long sumOfProperDivisors(int n) {
        long sum = 0;
        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
