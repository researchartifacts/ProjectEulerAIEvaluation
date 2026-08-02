package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class Gemini3FlashOneByOneQ228 {

    public ResponseDto Question228() {
        ResponseDto responseDto = new ResponseDto();
        Set<Rational> slopes = new HashSet<>();
        for (int n = 1864; n <= 1909; n++) {
            for (int k = 0; k < n; k++) {
                slopes.add(new Rational(k, n));
            }
        }
        responseDto.setAnswer(slopes.size());
        return responseDto;
    }

    private static class Rational {
        long p, q;
        Rational(long p, long q) {
            long g = gcd(p, q);
            this.p = p / g;
            this.q = q / g;
        }
        long gcd(long a, long b) { return b == 0 ? a : gcd(b, a % b); }
        @Override
        public boolean equals(Object o) {
            Rational r = (Rational) o;
            return p == r.p && q == r.q;
        }
        @Override
        public int hashCode() { return Objects.hash(p, q); }
    }
}
