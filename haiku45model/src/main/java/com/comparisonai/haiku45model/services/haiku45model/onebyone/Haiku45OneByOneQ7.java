package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ7 {

    public ResponseDto Question7() {
        ResponseDto responseDto = new ResponseDto();
        int count = 0;
        long n = 2;
        while (count < 10001) {
            if (isPrime(n)) {
                count++;
                if (count == 10001) {
                    responseDto.setAnswer(n);
                    return responseDto;
                }
            }
            n++;
        }
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
