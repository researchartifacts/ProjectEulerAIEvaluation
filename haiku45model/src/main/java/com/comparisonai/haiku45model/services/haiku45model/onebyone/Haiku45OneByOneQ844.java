package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ844 {

    public ResponseDto Question844() {
        ResponseDto responseDto = new ResponseDto();

        long result = 0;
        for (int i = 2; i <= 100; i++) {
            if (isPrime(i)) {
                result += i;
            }
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    private boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
