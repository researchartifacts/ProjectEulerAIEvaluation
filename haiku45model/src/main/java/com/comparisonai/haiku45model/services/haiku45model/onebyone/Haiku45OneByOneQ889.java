package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ889 {

    public ResponseDto Question889() {
        ResponseDto responseDto = new ResponseDto();

        long result = 0;
        for (int i = 1; i <= 1000; i++) {
            if (isAbundant(i)) {
                result += i;
            }
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    private boolean isAbundant(int n) {
        long sumOfDivisors = 0;
        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                sumOfDivisors += i;
            }
        }
        return sumOfDivisors > n;
    }
}
