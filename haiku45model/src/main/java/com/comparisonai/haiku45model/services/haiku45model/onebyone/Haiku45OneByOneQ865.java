package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ865 {

    public ResponseDto Question865() {
        ResponseDto responseDto = new ResponseDto();

        long result = 0;
        for (int i = 1; i <= 1000; i++) {
            if (isFibonacci(i)) {
                result += i;
            }
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    private boolean isFibonacci(int n) {
        long a = 0, b = 1;
        while (a < n) {
            long temp = a + b;
            a = b;
            b = temp;
        }
        return a == n;
    }
}
