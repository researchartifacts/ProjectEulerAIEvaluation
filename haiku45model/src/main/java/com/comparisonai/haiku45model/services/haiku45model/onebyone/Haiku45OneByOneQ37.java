package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ37 {

    public ResponseDto Question37() {
        ResponseDto responseDto = new ResponseDto();
        long sum = 0;
        int count = 0;
        for (int i = 10; i < 1000000 && count < 11; i++) {
            if (isTruncatablePrime(i)) {
                sum += i;
                count++;
            }
        }
        responseDto.setAnswer(sum);
        return responseDto;
    }

    private boolean isTruncatablePrime(int n) {
        String nStr = String.valueOf(n);
        for (int i = 0; i < nStr.length(); i++) {
            for (int j = i + 1; j <= nStr.length(); j++) {
                if (!isPrime(Long.parseLong(nStr.substring(i, j)))) {
                    return false;
                }
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
