package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class Gemini3FlashOneByOneQ50 {

    public ResponseDto Question50() {
        ResponseDto responseDto = new ResponseDto();
        int limit = 1000000;
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
        int maxLen = 0;
        long maxPrime = 0;
        for (int i = 0; i < primes.size(); i++) {
            long sum = 0;
            for (int j = i; j < primes.size(); j++) {
                sum += primes.get(j);
                if (sum >= limit) break;
                if (j - i + 1 > maxLen && isPrime[(int) sum]) {
                    maxLen = j - i + 1;
                    maxPrime = sum;
                }
            }
        }
        responseDto.setAnswer(maxPrime);
        return responseDto;
    }
}
