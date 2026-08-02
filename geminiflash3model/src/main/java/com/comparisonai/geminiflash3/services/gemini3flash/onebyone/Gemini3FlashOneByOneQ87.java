package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class Gemini3FlashOneByOneQ87 {

    public ResponseDto Question87() {
        ResponseDto responseDto = new ResponseDto();
        int limit = 50000000;
        int maxP = (int) Math.sqrt(limit);
        boolean[] isPrime = new boolean[maxP + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        List<Integer> primes = new ArrayList<>();
        for (int p = 2; p <= maxP; p++) {
            if (isPrime[p]) {
                primes.add(p);
                for (int i = p * 2; i <= maxP; i += p) isPrime[i] = false;
            }
        }
        Set<Integer> sums = new HashSet<>();
        for (int p1 : primes) {
            long s1 = (long) p1 * p1;
            if (s1 >= limit) break;
            for (int p2 : primes) {
                long s2 = s1 + (long) p2 * p2 * p2;
                if (s2 >= limit) break;
                for (int p3 : primes) {
                    long s3 = s2 + (long) p3 * p3 * p3 * p3;
                    if (s3 >= limit) break;
                    sums.add((int) s3);
                }
            }
        }
        responseDto.setAnswer(sums.size());
        return responseDto;
    }
}
