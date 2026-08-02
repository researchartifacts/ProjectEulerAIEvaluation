package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ51 {

    public ResponseDto Question51() {
        ResponseDto responseDto = new ResponseDto();
        for (int i = 10; i < 1000000; i++) {
            String iStr = String.valueOf(i);
            int length = iStr.length();
            for (int mask = 1; mask < (1 << length); mask++) {
                int primeCount = 0;
                for (int digit = 0; digit <= 9; digit++) {
                    StringBuilder candidate = new StringBuilder(iStr);
                    for (int j = 0; j < length; j++) {
                        if ((mask & (1 << j)) != 0) {
                            candidate.setCharAt(j, (char) ('0' + digit));
                        }
                    }
                    long num = Long.parseLong(candidate.toString());
                    if (num >= Math.pow(10, length - 1) && isPrime(num)) {
                        primeCount++;
                    }
                }
                if (primeCount == 8) {
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
