package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class Gemini3FlashOneByOneQ155 {

    static class Fraction implements Comparable<Fraction> {
        long num, den;
        Fraction(long n, long d) {
            long common = gcd(n, d);
            num = n / common;
            den = d / common;
        }
        static long gcd(long a, long b) {
            while (b != 0) { a %= b; long t = a; a = b; b = t; }
            return a;
        }
        @Override
        public int compareTo(Fraction o) {
            return Long.compare(this.num * o.den, o.num * this.den);
        }
        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Fraction)) return false;
            Fraction f = (Fraction) o;
            return num == f.num && den == f.den;
        }
        @Override
        public int hashCode() {
            return Objects.hash(num, den);
        }
    }

    public ResponseDto Question155() {
        ResponseDto responseDto = new ResponseDto();
        int n = 18;
        List<Set<Fraction>> s = new ArrayList<>();
        for (int i = 0; i <= n; i++) s.add(new HashSet<>());
        
        s.get(1).add(new Fraction(1, 1));
        Set<Fraction> all = new HashSet<>();
        all.add(new Fraction(1, 1));
        
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                for (Fraction f1 : s.get(j)) {
                    for (Fraction f2 : s.get(i - j)) {
                        // Parallel
                        Fraction p = new Fraction(f1.num * f2.den + f2.num * f1.den, f1.den * f2.den);
                        s.get(i).add(p);
                        // Series
                        Fraction ser = new Fraction(f1.num * f2.num, f1.num * f2.den + f2.num * f1.den);
                        s.get(i).add(ser);
                    }
                }
            }
            all.addAll(s.get(i));
        }
        
        responseDto.setAnswer(all.size());
        return responseDto;
    }
}
