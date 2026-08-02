package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ868 {

    public ResponseDto Question868() {
        ResponseDto responseDto = new ResponseDto();

        long result = 0;
        for (int i = 2; i <= 1000; i++) {
            result += phiFunction(i);
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    private long phiFunction(int n) {
        long result = n;
        for (int p = 2; p * p <= n; p++) {
            if (n % p == 0) {
                while (n % p == 0) {
                    n /= p;
                }
                result -= result / p;
            }
        }
        if (n > 1) {
            result -= result / n;
        }
        return result;
    }
}
