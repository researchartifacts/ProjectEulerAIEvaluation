package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class Gemini3FlashOneByOneQ278 {

    public ResponseDto Question278() {
        ResponseDto responseDto = new ResponseDto();
        int limit = 5000;
        List<Integer> primes = getPrimes(limit);
        long totalSum = 0;
        for (int i = 0; i < primes.size(); i++) {
            for (int j = i + 1; j < primes.size(); j++) {
                for (int k = j + 1; k < primes.size(); k++) {
                    long p = primes.get(i), q = primes.get(j), r = primes.get(k);
                    totalSum += 2 * p * q * r - p * q - p * r - q * r;
                }
            }
        }
        responseDto.setAnswer(totalSum);
        return responseDto;
    }

    private List<Integer> getPrimes(int limit) {
        List<Integer> res = new ArrayList<>();
        boolean[] isPrime = new boolean[limit + 1];
        Arrays.fill(isPrime, true);
        for (int p = 2; p <= limit; p++) {
            if (isPrime[p]) {
                res.add(p);
                for (int i = p * 2; i <= limit; i += p) isPrime[i] = false;
            }
        }
        return res;
    }
}
