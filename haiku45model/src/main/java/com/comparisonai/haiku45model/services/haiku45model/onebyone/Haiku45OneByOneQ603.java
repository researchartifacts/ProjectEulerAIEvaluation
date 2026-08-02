package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ603 {

    public ResponseDto Question603() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;
        int maxPrimes = 2000;
        boolean[] isPrime = new boolean[maxPrimes];
        java.util.Arrays.fill(isPrime, true);
        for (int i = 2; i < maxPrimes; i++) {
            if (isPrime[i]) {
                for (int j = i + i; j < maxPrimes; j += i) isPrime[j] = false;
            }
        }
        StringBuilder P = new StringBuilder();
        for (int i = 2; i < maxPrimes && P.length() < 1000; i++) {
            if (isPrime[i]) P.append(i);
        }
        for (int i = 0; i < P.length() && i < 100; i++) {
            for (int j = i; j < Math.min(P.length(), i + 100); j++) {
                long val = Long.parseLong(P.substring(i, j + 1));
                result = (result + val) % 1000000007L;
            }
        }
        responseDto.setAnswer(result);
        return responseDto;
    }
}
