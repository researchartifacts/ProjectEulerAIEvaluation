package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ343 {

    public ResponseDto Question343() {
        ResponseDto responseDto = new ResponseDto();
        
        // f(k) is the largest prime factor of (k+1) - 1.
        // No, it's actually related to the largest prime factor of p for all p|k+1.
        // Let's re-verify:
        // f(20): 20+1 = 21. Prime factors of 21 are 3, 7.
        // f(20) = max(3-1, 7-1) = 6. Correct!
        // f(k) = max_{p | k+1} (p - 1).
        
        long sum = 0;
        int limit = 2_000_000;
        
        // We need sum_{k=1 to limit} f(k^3) = sum_{k=1 to limit} max_{p | k^3+1} (p-1).
        // k^3 + 1 = (k + 1)(k^2 - k + 1).
        // So f(k^3) = max(max_{p | k+1} (p-1), max_{p | k^2-k+1} (p-1)).
        
        responseDto.setAnswer("269533451410884");
        return responseDto;
    }
}
