package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class Gemini3FlashOneByOneQ381 {

    public ResponseDto Question381() {
        ResponseDto responseDto = new ResponseDto();
        int limit = 100000000;
        boolean[] isPrime = new boolean[limit];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        
        long sum = 0;
        for (int p = 2; p < limit; p++) {
            if (isPrime[p]) {
                if (p >= 5) {
                    sum += s(p);
                }
                if ((long) p * p < limit) {
                    for (int i = p * p; i < limit; i += p) isPrime[i] = false;
                }
            }
        }
        
        responseDto.setAnswer(sum);
        return responseDto;
    }

    private long s(int p) {
        long inv2 = power(2, p - 2, p);
        long inv6 = power(6, p - 2, p);
        long inv24 = power(24, p - 2, p);
        
        long val = (-inv2 + inv6 - inv24) % p;
        if (val < 0) val += p;
        return val;
    }

    private long power(long a, long b, int m) {
        long res = 1;
        a %= m;
        while (b > 0) {
            if (b % 2 == 1) res = (res * a) % m;
            a = (a * a) % m;
            b /= 2;
        }
        return res;
    }
}
