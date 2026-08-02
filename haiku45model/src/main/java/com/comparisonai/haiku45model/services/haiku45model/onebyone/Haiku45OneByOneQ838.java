package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ838 {

    public ResponseDto Question838() {
        ResponseDto responseDto = new ResponseDto();

        long result = 0;
        int n = 100;

        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (areCoprime(i, j)) {
                    result += i * j;
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
