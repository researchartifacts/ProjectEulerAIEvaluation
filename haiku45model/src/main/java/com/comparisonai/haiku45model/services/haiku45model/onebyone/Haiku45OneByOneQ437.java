package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ437 {

    public ResponseDto Question437() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;
        int limit = 100000;

        boolean[] isPrime = sieveOfEratosthenes(limit);

        for (int p = 2; p <= limit; p++) {
            if (isPrime[p]) {
                if (hasFibonacciPrimitiveRoot(p)) {
                    result += p;
                }
            }
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    private boolean[] sieveOfEratosthenes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        for (int i = 2; i <= n; i++) isPrime[i] = true;
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }

    private boolean hasFibonacciPrimitiveRoot(int p) {
        return p % 10 == 1 || p % 10 == 9;
    }
}
