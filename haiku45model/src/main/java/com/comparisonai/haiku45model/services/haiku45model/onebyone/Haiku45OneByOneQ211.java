package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ211 {

    public ResponseDto Question211() {
        ResponseDto responseDto = new ResponseDto();

        // Problem 211: Sum of integers n where σ₂(n) is a perfect square
        // σ₂(n) = sum of squares of divisors
        // Find sum of all n: 0 < n < 64,000,000 where σ₂(n) is perfect square

        long limit = 64000000L;
        long result = 0;

        for (long n = 1; n < limit; n++) {
            long sigma2 = calculateSigma2(n);
            if (isPerfectSquare(sigma2)) {
                result += n;
            }
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    private long calculateSigma2(long n) {
        // Calculate sum of squares of all divisors of n
        long sum = 0;

        for (long i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                sum += i * i;
                if (i != n / i) {
                    sum += (n / i) * (n / i);
                }
            }
        }

        return sum;
    }

    private boolean isPerfectSquare(long n) {
        long sqrt = (long) Math.sqrt(n);
        return sqrt * sqrt == n;
    }
}
