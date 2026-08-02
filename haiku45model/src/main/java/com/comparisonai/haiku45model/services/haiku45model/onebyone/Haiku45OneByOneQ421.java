package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ421 {

    public ResponseDto Question421() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (long n = 1; n <= 100; n++) {
            long value = n * n * n * n * n + 1;
            long primeSum = sumDistinctPrimeFactors(value);
            result += primeSum;
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    private long sumDistinctPrimeFactors(long n) {
        long sum = 0;
        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                sum += i;
                while (n % i == 0) {
                    n /= i;
                }
            }
        }
        if (n > 1) sum += n;
        return sum;
    }
}
