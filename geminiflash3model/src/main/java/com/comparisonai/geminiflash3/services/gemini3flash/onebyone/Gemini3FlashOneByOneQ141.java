package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class Gemini3FlashOneByOneQ141 {

    public ResponseDto Question141() {
        ResponseDto responseDto = new ResponseDto();
        long limit = 1000000000000L;
        Set<Long> progressiveSquares = new HashSet<>();
        
        for (long a = 2; a * a * a < limit; a++) {
            for (long b = 1; b < a; b++) {
                if (gcd(a, b) != 1) continue;
                for (long m = 1; ; m++) {
                    long n = m * m * a * a * a * b + m * b * b;
                    if (n >= limit) break;
                    if (isPerfectSquare(n)) {
                        progressiveSquares.add(n);
                    }
                }
            }
        }
        
        long sum = 0;
        for (long n : progressiveSquares) sum += n;
        
        responseDto.setAnswer(sum);
        return responseDto;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            a %= b;
            long temp = a;
            a = b;
            b = temp;
        }
        return a;
    }

    private boolean isPerfectSquare(long n) {
        if (n < 0) return false;
        long sqrt = (long) Math.sqrt(n);
        return sqrt * sqrt == n;
    }
}
