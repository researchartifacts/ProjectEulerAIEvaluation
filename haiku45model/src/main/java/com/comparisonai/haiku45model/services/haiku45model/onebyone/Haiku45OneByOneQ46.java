package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ46 {

    public ResponseDto Question46() {
        ResponseDto responseDto = new ResponseDto();
        for (int i = 9; i < 1000000; i += 2) {
            if (!isPrime(i)) {
                boolean found = false;
                for (int j = 1; j * j < i; j++) {
                    int diff = i - 2 * j * j;
                    if (diff > 0 && isPrime(diff)) {
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    responseDto.setAnswer(i);
                    return responseDto;
                }
            }
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
