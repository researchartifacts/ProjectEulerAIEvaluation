package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Gemini3FlashOneByOneQ123 {

    public ResponseDto Question123() {
        ResponseDto responseDto = new ResponseDto();
        long limit = 10000000000L;
        int maxN = 1000000; // Large enough to find n
        boolean[] isPrime = new boolean[maxN];
        for (int i = 2; i < maxN; i++) isPrime[i] = true;
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i < maxN; i++) {
            if (isPrime[i]) {
                primes.add(i);
                for (int j = 2 * i; j < maxN; j += i) isPrime[j] = false;
            }
        }

        int n = 0;
        for (int p : primes) {
            n++;
            if (n % 2 == 0) continue;
            long r = 2L * n * p;
            if (r > limit) {
                responseDto.setAnswer(String.valueOf(n));
                break;
            }
        }
        return responseDto;
    }
}
