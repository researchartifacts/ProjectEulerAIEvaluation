package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ609 {

    public ResponseDto Question609() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;
        long MOD = 1000000007L;
        int n = 100000;
        boolean[] isPrime = new boolean[n];
        java.util.Arrays.fill(isPrime, true);
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                for (int j = i + i; j < n; j += i) isPrime[j] = false;
            }
        }
        long count = 0;
        for (int u = 1; u <= Math.min(n, 10000); u++) {
            int nonPrimes = 0;
            int temp = u;
            while (temp > 1) {
                if (!isPrime[temp]) nonPrimes++;
                temp = temp / 2;
            }
            count = (count + nonPrimes) % MOD;
        }
        result = count;
        responseDto.setAnswer(result);
        return responseDto;
    }
}
