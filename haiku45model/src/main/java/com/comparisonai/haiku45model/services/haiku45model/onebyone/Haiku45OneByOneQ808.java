package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ808 {

    public ResponseDto Question808() {
        ResponseDto responseDto = new ResponseDto();

        long sum = 0;
        int count = 0;

        for (long p = 2; count < 50; p++) {
            if (isPrime(p)) {
                long primeSquare = p * p;
                String original = String.valueOf(primeSquare);
                String reversed = new StringBuilder(original).reverse().toString();
                long reversedNum = Long.parseLong(reversed);

                if (!original.equals(reversed)) {
                    long sqrtReversed = (long) Math.sqrt(reversedNum);
                    if (sqrtReversed * sqrtReversed == reversedNum && isPrime(sqrtReversed)) {
                        sum += primeSquare;
                        count++;
                    }
                }
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
