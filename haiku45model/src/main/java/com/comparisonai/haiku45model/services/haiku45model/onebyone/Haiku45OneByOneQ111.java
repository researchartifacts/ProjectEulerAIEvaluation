package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ111 {

    public ResponseDto Question111() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        // Primes with repeated digits
        long primeSum = 0;
        int digitD = 1;
        for (int d = 0; d <= 9; d++) {
            long maxPrime = 0;
            int count = 0;
            for (int n = 1000; n <= 9999; n++) {
                if (isPrime(n)) {
                    String s = String.valueOf(n);
                    int digitCount = 0;
                    for (char c : s.toCharArray()) {
                        if (c - '0' == d) digitCount++;
                    }
                    if (digitCount >= 3 && n > maxPrime) {
                        maxPrime = n;
                        count++;
                    }
                }
            }
            primeSum += Math.min(maxPrime, 10000);
        }
        result = primeSum;

        responseDto.setAnswer(result);
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

