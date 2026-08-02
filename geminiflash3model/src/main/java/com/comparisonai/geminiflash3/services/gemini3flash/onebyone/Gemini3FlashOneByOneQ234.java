package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class Gemini3FlashOneByOneQ234 {

    public ResponseDto Question234() {
        ResponseDto responseDto = new ResponseDto();
        long limit = 999966663333L;
        
        List<Integer> primes = getPrimes((int) Math.sqrt(limit) + 1000);
        long totalSum = 0;
        for (int i = 0; i < primes.size() - 1; i++) {
            long p1 = primes.get(i);
            long p2 = primes.get(i + 1);
            long start = p1 * p1 + 1;
            long end = Math.min(limit, p2 * p2 - 1);
            if (start > end) break;
            
            // Numbers in [start, end] divisible by p1 or p2 but not both
            totalSum += sumMultiples(p1, start, end);
            totalSum += sumMultiples(p2, start, end);
            totalSum -= 2 * sumMultiples(p1 * p2, start, end);
        }
        
        responseDto.setAnswer(totalSum);
        return responseDto;
    }

    private long sumMultiples(long p, long start, long end) {
        long first = (start + p - 1) / p * p;
        long last = end / p * p;
        if (first > last) return 0;
        long n = (last - first) / p + 1;
        return n * (first + last) / 2;
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
