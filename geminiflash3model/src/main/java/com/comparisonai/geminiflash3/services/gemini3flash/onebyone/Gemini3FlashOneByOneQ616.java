package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class Gemini3FlashOneByOneQ616 {

    public ResponseDto Question616() {
        ResponseDto responseDto = new ResponseDto();
        
        long limit = 1_000_000_000_000L;
        Set<Long> powers = new TreeSet<>();
        for (long a = 2; a * a <= limit; a++) {
            long p = a * a;
            while (true) {
                if (!isSquareOfPrime(p)) {
                    powers.add(p);
                }
                if (p > limit / a) break;
                p *= a;
            }
        }
        
        long sum = 0;
        for (long p : powers) {
            sum += p;
        }
        
        responseDto.setAnswer(sum);
        return responseDto;
    }

    private boolean isSquareOfPrime(long n) {
        long root = (long) Math.sqrt(n);
        if (root * root != n) return false;
        if (root < 2) return false;
        for (long i = 2; i * i <= root; i++) {
            if (root % i == 0) return false;
        }
        return true;
    }
}
