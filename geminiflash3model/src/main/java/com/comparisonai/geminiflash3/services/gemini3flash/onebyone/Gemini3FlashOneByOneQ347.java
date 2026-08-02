package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class Gemini3FlashOneByOneQ347 {

    public ResponseDto Question347() {
        ResponseDto responseDto = new ResponseDto();
        
        int N = 10_000_000;
        boolean[] isPrime = new boolean[N / 2 + 1];
        Arrays.fill(isPrime, true);
        List<Integer> primes = new ArrayList<>();
        for (int p = 2; p < isPrime.length; p++) {
            if (isPrime[p]) {
                primes.add(p);
                for (int i = 2 * p; i < isPrime.length; i += p) isPrime[i] = false;
            }
        }
        
        Set<Integer> distinctM = new HashSet<>();
        for (int i = 0; i < primes.size(); i++) {
            long p = primes.get(i);
            if (p * p > N) break;
            for (int j = i + 1; j < primes.size(); j++) {
                long q = primes.get(j);
                if (p * q > N) break;
                
                long maxPQ = 0;
                for (long pp = p; pp * q <= N; pp *= p) {
                    long val = pp * q;
                    while (val * q <= N) val *= q;
                    if (val > maxPQ) maxPQ = val;
                }
                if (maxPQ > 0) distinctM.add((int) maxPQ);
            }
        }
        
        long sum = 0;
        for (int m : distinctM) sum += m;
        
        responseDto.setAnswer(sum);
        return responseDto;
    }
}
