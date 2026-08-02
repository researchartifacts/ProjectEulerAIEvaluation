package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ847 {

    public ResponseDto Question847() {
        ResponseDto responseDto = new ResponseDto();

        long result = 0;
        for (int i = 1; i <= 1000; i++) {
            result += fibonacci(i) % 1000000007;
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    private long fibonacci(int n) {
        if (n <= 1) return n;
        long a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            long temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }
}
