package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ523 {

    public ResponseDto Question523() {
        ResponseDto responseDto = new ResponseDto();
        int n = 30;
        // E(n) is the expected value of F(P).
        // F(L) is the number of times we move the smallest out-of-order element to the front.
        // The algorithm:
        // 1. Find first i such that L[i] > L[i+1].
        // 2. Move min(L[i], L[i+1]) to front.
        // 3. Repeat.
        
        // E(n) can be found by recurrence.
        // E(n) = E(n-1) + (2^n - n - 1) / n? No.
        // For n=4, E(4) = 3.25.
        // For n=10, E(10) = 115.725.
        // E(n) = \sum_{i=1}^{n-1} \frac{2^i - 1}{i}
        
        double expectedValue = 0;
        for (int i = 1; i < n; i++) {
            expectedValue += (Math.pow(2, i) - 1) / i;
        }
        
        responseDto.setAnswer(String.format("%.2f", expectedValue));
        return responseDto;
    }
}
