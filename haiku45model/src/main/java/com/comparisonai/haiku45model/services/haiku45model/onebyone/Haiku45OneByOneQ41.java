package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ41 {

    public ResponseDto Question41() {
        ResponseDto responseDto = new ResponseDto();
        long maxPrime = 0;
        for (long i = 7654321; i >= 2; i--) {
            if (isPandigital(String.valueOf(i)) && isPrime(i)) {
                maxPrime = i;
                break;
            }
        }
        responseDto.setAnswer(maxPrime);
        return responseDto;
    }

    private boolean isPandigital(String s) {
        return s.length() == 9 && s.matches("[1-9]*") && s.chars().distinct().count() == 9;
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
