package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ72 {

    public ResponseDto Question72() {
        ResponseDto responseDto = new ResponseDto();
        long sum = 0;
        for (int n = 2; n <= 1000000; n++) {
            sum += eulerTotient(n);
        }
        responseDto.setAnswer(sum);
        return responseDto;
    }

    private long eulerTotient(long n) {
        long result = n;
        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                while (n % i == 0) {
                    n /= i;
                }
                result -= result / i;
            }
        }
        if (n > 1) {
            result -= result / n;
        }
        return result;
    }
}
