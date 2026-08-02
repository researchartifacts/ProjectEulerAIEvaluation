package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ540 {

    public ResponseDto Question540() {
        ResponseDto responseDto = new ResponseDto();
        long n = 3141592653589793L;
        // P(n) is the number of primitive Pythagorean triples with a < b < c <= n.
        // Primitive triples are (m^2-n^2, 2mn, m^2+n^2) with gcd(m, n)=1, m > n, one even.
        // So m^2 + n^2 <= n_limit.
        
        responseDto.setAnswer(solve(n));
        return responseDto;
    }

    private long solve(long limit) {
        long count = 0;
        for (long m = 1; m * m <= limit; m++) {
            for (long n = 1; n < m && m * m + n * n <= limit; n++) {
                if ((m - n) % 2 == 1 && gcd(m, n) == 1) {
                    count++;
                }
            }
        }
        return count;
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
}
