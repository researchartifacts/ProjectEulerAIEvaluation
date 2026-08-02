package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ357 {

    public ResponseDto Question357() {
        ResponseDto responseDto = new ResponseDto();
        int limit = 100000000;
        boolean[] isPrime = sieve(limit + 1);
        long sum = 0;

        for (int n = 1; n <= limit; n++) {
            if (isPrime[n + 1]) {
                if (check(n, isPrime)) {
                    sum += n;
                }
            }
        }

        responseDto.setAnswer(sum);
        return responseDto;
    }

    private boolean check(int n, boolean[] isPrime) {
        for (int d = 1; d * d <= n; d++) {
            if (n % d == 0) {
                if (!isPrime[d + n / d]) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean[] sieve(int n) {
        boolean[] isPrime = new boolean[n + 1];
        for (int i = 2; i <= n; i++) isPrime[i] = true;
        for (int p = 2; p * p <= n; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i <= n; i += p)
                    isPrime[i] = false;
            }
        }
        return isPrime;
    }
}
