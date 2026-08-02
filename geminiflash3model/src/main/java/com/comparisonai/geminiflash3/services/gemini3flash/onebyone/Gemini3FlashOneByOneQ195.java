package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ195 {

    public ResponseDto Question195() {
        ResponseDto responseDto = new ResponseDto();
        long limit = 1053779;
        long count = 0;
        // 60-degree triangle: a^2 + b^2 - ab = c^2
        // Parametrization: a = m^2 - n^2, b = 2mn - n^2, c = m^2 + n^2 - mn
        // r = sqrt(3)/2 * (a*b)/(a+b+c) = sqrt(3)/2 * (m-n)*n
        
        for (long n = 1; ; n++) {
            long m = n + 1;
            if (Math.sqrt(3) / 2.0 * (m - n) * n > limit) break;
            while (true) {
                if (gcd(m, n) == 1 && (m - n) % 3 != 0) {
                    double r = Math.sqrt(3) / 2.0 * (m - n) * n;
                    if (r > limit) break;
                    count += (long) (limit / r);
                }
                m++;
            }
        }
        responseDto.setAnswer(String.valueOf(count));
        return responseDto;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            a %= b;
            long t = a; a = b; b = t;
        }
        return a;
    }
}
