package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ216 {

    public ResponseDto Question216() {
        ResponseDto responseDto = new ResponseDto();

        // Problem 216: Count primes of form t(n) = 2n^2 - 1
        // Find how many such numbers are prime for n <= 50,000,000

        long limit = 50000000L;
        long count = 0;

        // Check primality for each t(n)
        for (long n = 2; n <= limit; n++) {
            long t = 2 * n * n - 1;

            if (isPrime(t)) {
                count++;
            }
        }

        responseDto.setAnswer(count);
        return responseDto;
    }

    private boolean isPrime(long n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        if (n == 3) return true;
        if (n % 3 == 0) return false;

        for (long i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }

        return true;
    }
}
