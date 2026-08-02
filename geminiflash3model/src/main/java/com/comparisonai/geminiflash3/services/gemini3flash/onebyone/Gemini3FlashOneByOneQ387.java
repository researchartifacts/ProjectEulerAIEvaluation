package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Gemini3FlashOneByOneQ387 {

    public ResponseDto Question387() {
        ResponseDto responseDto = new ResponseDto();
        long limit = 100000000000000L;
        long sum = 0;
        
        List<Harshad> current = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            current.add(new Harshad(i, i));
        }
        
        while (!current.isEmpty()) {
            List<Harshad> next = new ArrayList<>();
            for (Harshad h : current) {
                for (int d = 0; d <= 9; d++) {
                    long val = h.val * 10 + d;
                    if (val >= limit) continue;
                    int sumDigits = h.sumDigits + d;
                    if (val % sumDigits == 0) {
                        Harshad nextH = new Harshad(val, sumDigits);
                        next.add(nextH);
                        
                        if (isPrime(val / sumDigits)) {
                            // Check if val * 10 + d2 is prime
                            for (int d2 : new int[]{1, 3, 7, 9}) {
                                long p = val * 10 + d2;
                                if (p < limit && isPrime(p)) {
                                    sum += p;
                                }
                            }
                        }
                    }
                }
            }
            current = next;
        }
        
        responseDto.setAnswer(sum);
        return responseDto;
    }

    private static class Harshad {
        long val;
        int sumDigits;
        Harshad(long v, int s) { val = v; sumDigits = s; }
    }

    private boolean isPrime(long n) {
        if (n < 2) return false;
        if (n < 4) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        for (long i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }
}
