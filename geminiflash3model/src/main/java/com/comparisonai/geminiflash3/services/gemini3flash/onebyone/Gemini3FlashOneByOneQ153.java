package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ153 {

    public ResponseDto Question153() {
        ResponseDto responseDto = new ResponseDto();
        long N = 100000000L;
        long totalSum = 0;
        
        // Sum a * floor(N / (a^2+b^2)) for all a >= 1, b s.t. a^2+b^2 <= N.
        // Rational integers (b=0): a | n, sum is standard sigma(N).
        for (long a = 1; a <= N; a++) {
            totalSum += a * (N / a);
        }
        
        // Gaussian integers with b != 0.
        // For each pair (a, b) with a, b > 0 and gcd(a, b) = 1:
        // Divisors are g*(a+bi), g*(a-bi), g*(b+ai), g*(b-ai) ...
        // Real part of g(a+bi) is ga. Sum is ga * floor(N / (g^2(a^2+b^2))).
        for (long a = 1; a * a < N; a++) {
            for (long b = 1; a * a + b * b <= N; b++) {
                if (gcd(a, b) != 1) continue;
                long d = a * a + b * b;
                for (long g = 1; g * g * d <= N; g++) {
                    totalSum += (a + b) * g * (N / (g * g * d));
                }
            }
        }
        
        responseDto.setAnswer(totalSum);
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
}
