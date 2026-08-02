package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ35 {

    public ResponseDto Question35() {
        ResponseDto responseDto = new ResponseDto();
        int count = 0;
        for (int i = 2; i < 1000000; i++) {
            if (isCircularPrime(i)) {
                count++;
            }
        }
        responseDto.setAnswer(count);
        return responseDto;
    }

    private boolean isCircularPrime(int n) {
        String nStr = String.valueOf(n);
        int rotations = nStr.length();
        for (int i = 0; i < rotations; i++) {
            String rotated = nStr.substring(i) + nStr.substring(0, i);
            if (!isPrime(Long.parseLong(rotated))) {
                return false;
            }
        }
        return true;
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
