package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class Gemini3FlashOneByOneQ77 {

    public ResponseDto Question77() {
        ResponseDto responseDto = new ResponseDto();
        int limit = 1000;
        boolean[] isPrime = new boolean[limit];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        List<Integer> primes = new ArrayList<>();
        for (int p = 2; p < limit; p++) {
            if (isPrime[p]) {
                primes.add(p);
                for (int i = p * 2; i < limit; i += p) isPrime[i] = false;
            }
        }
        for (int n = 10; ; n++) {
            long[] ways = new long[n + 1];
            ways[0] = 1;
            for (int p : primes) {
                if (p > n) break;
                for (int i = p; i <= n; i++) ways[i] += ways[i - p];
            }
            if (ways[n] > 5000) {
                responseDto.setAnswer(n);
                break;
            }
        }
        return responseDto;
    }
}
