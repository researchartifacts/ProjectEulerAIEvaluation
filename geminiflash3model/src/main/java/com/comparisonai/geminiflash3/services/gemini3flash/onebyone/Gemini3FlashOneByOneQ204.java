package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class Gemini3FlashOneByOneQ204 {

    public ResponseDto Question204() {
        ResponseDto responseDto = new ResponseDto();
        int type = 100;
        long limit = 1_000_000_000L;
        
        List<Integer> primes = new ArrayList<>();
        boolean[] isPrime = new boolean[type + 1];
        Arrays.fill(isPrime, true);
        for (int p = 2; p <= type; p++) {
            if (isPrime[p]) {
                primes.add(p);
                for (int i = p * 2; i <= type; i += p) isPrime[i] = false;
            }
        }
        
        long count = countHamming(0, 1, limit, primes);
        responseDto.setAnswer(count);
        return responseDto;
    }

    private long countHamming(int startIdx, long current, long limit, List<Integer> primes) {
        long count = 1;
        for (int i = startIdx; i < primes.size(); i++) {
            long p = primes.get(i);
            if (current > limit / p) break;
            count += countHamming(i, current * p, limit, primes);
        }
        return count;
    }
}
