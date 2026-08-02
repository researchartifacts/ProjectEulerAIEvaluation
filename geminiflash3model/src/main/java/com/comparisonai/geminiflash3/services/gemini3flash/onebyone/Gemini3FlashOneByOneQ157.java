package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class Gemini3FlashOneByOneQ157 {

    public ResponseDto Question157() {
        ResponseDto responseDto = new ResponseDto();
        long total = 0;
        for (int n = 1; n <= 9; n++) {
            total += countSolutions(n);
        }
        responseDto.setAnswer(total);
        return responseDto;
    }

    private long countSolutions(int n) {
        long count = 0;
        long tenN = (long) Math.pow(10, n);
        
        // a = gx, b = gy, gcd(x, y) = 1. g | (10^n / xy) * (x+y).
        // x, y are coprime divisors of 10^n.
        List<Long> divisors = getDivisors(tenN);
        for (int i = 0; i < divisors.size(); i++) {
            for (int j = i; j < divisors.size(); j++) {
                long x = divisors.get(i);
                long y = divisors.get(j);
                if (gcd(x, y) != 1) continue;
                
                long val = (tenN / (x * y)) * (x + y);
                count += countDivisors(val);
            }
        }
        return count;
    }

    private List<Long> getDivisors(long n) {
        List<Long> res = new ArrayList<>();
        for (long i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                res.add(i);
                if (i * i != n) res.add(n / i);
            }
        }
        return res;
    }

    private long countDivisors(long n) {
        long count = 0;
        for (long i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                count++;
                if (i * i != n) count++;
            }
        }
        return count;
    }

    private long gcd(long a, long b) {
        while (b != 0) { a %= b; long t = a; a = b; b = t; }
        return a;
    }
}
