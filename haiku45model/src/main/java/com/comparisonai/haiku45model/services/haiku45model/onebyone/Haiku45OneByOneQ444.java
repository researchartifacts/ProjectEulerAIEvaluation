package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ444 {

    public ResponseDto Question444() {
        ResponseDto responseDto = new ResponseDto();
        double result = 1.0;

        for (int iteration = 0; iteration < 10; iteration++) {
            long sum = 0;
            for (int i = 1; i <= 20; i++) {
                sum += fibonacci(i);
            }
            result = Math.sqrt(result * sum);
        }

        responseDto.setAnswer((long) result);
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
