package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ886 {

    public ResponseDto Question886() {
        ResponseDto responseDto = new ResponseDto();

        long result = 0;
        for (int i = 1; i <= 100; i++) {
            for (int j = 1; j <= 100; j++) {
                if (areCoprime(i, j)) {
                    result++;
                }
            }
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    private boolean areCoprime(long a, long b) {
        return gcd(a, b) == 1;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
