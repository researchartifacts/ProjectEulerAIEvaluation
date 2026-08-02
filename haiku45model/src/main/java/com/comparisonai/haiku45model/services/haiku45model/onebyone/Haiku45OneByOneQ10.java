package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ10 {

    public ResponseDto Question10() {
        ResponseDto responseDto = new ResponseDto();
        long sum = 0;
        for (int i = 2; i < 2000000; i++) {
            if (isPrime(i)) {
                sum += i;
            }
        }
        responseDto.setAnswer(sum);
        return responseDto;
    }

    private boolean isPrime(long n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (long i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
