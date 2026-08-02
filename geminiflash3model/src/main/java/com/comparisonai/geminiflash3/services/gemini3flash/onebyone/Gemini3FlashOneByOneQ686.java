package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ686 {

    public ResponseDto Question686() {
        ResponseDto responseDto = new ResponseDto();

        int L = 123;
        int n = 678910;
        
        // p(L, n) is the n-th j such that 2^j starts with L.
        // 10^k * L <= 2^j < 10^k * (L+1)
        // k + log10(L) <= j * log10(2) < k + log10(L+1)
        // log10(L) <= j * log10(2) - k < log10(L+1)
        // Let frac(x) = x - floor(x).
        // Since k = floor(j * log10(2) - log10(L)), we need
        // log10(L) - floor(log10(L)) <= frac(j * log10(2) - floor(log10(L))) ...
        // Actually, it's simpler:
        // Let m be the number of digits in L.
        // log10(L/10^(m-1)) <= j * log10(2) mod 1 < log10((L+1)/10^(m-1))
        
        double log10_2 = Math.log10(2.0);
        double lower = Math.log10(L);
        double upper = Math.log10(L + 1);
        
        // Number of digits in L
        int m = String.valueOf(L).length();
        // Adjust L to be between 1 and 10
        double low = lower - Math.floor(lower);
        double up = upper - Math.floor(lower);
        
        long count = 0;
        long j = 0;
        while (count < n) {
            j++;
            double val = (j * log10_2) % 1.0;
            if (val >= low && val < up) {
                count++;
            }
        }

        responseDto.setAnswer(j);
        return responseDto;
    }
}
