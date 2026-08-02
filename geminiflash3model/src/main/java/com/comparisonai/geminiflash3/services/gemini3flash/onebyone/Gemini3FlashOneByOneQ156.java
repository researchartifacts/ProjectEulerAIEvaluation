package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ156 {

    public ResponseDto Question156() {
        ResponseDto responseDto = new ResponseDto();
        long totalSum = 0;
        for (int d = 1; d <= 9; d++) {
            totalSum += s(d);
        }
        responseDto.setAnswer(totalSum);
        return responseDto;
    }

    private long s(int d) {
        long sum = 0;
        // Search for n such that f(n, d) = n. 
        // f(n, d) is bounded by ~ n * log10(n) / 10.
        // For n = 10^11, f(n, d) ~ 1.1 * 10^10.
        // Let's use a recursive search.
        sum += findSolutions(d, 0, 1000000000000L);
        return sum;
    }

    private long findSolutions(int d, long low, long high) {
        long flow = f(low, d);
        long fhigh = f(high, d);
        if (flow > high || fhigh < low) return 0;
        if (low == high) return (flow == low) ? low : 0;
        
        long mid = (low + high) / 2;
        return findSolutions(d, low, mid) + findSolutions(d, mid + 1, high);
    }

    private long f(long n, int d) {
        if (n <= 0) return 0;
        long count = 0;
        long factor = 1;
        long lower = 0;
        long current = 0;
        long upper = 0;
        
        while (n / factor > 0) {
            lower = n - (n / factor) * factor;
            current = (n / factor) % 10;
            upper = n / (factor * 10);
            
            if (current < d) count += upper * factor;
            else if (current == d) count += upper * factor + lower + 1;
            else count += (upper + 1) * factor;
            
            factor *= 10;
        }
        return count;
    }
}
