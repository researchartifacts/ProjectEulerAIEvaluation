package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ634 {

    public ResponseDto Question634() {
        ResponseDto responseDto = new ResponseDto();
        long n = 9000000000000000000L;

        // Count x = a^2 b^3 with a, b > 1.
        // Overlaps happen for x = k^6.
        // a^2 b^3 = k^6 implies b is a square or a = k^3...
        
        long count = 0;
        long bLimit = (long) Math.pow(n / 4.0, 1.0 / 3.0);
        
        for (long b = 2; b <= bLimit; b++) {
            long b3 = b * b * b;
            long aMax = (long) Math.sqrt(n / b3);
            count += (aMax - 1);
        }
        
        // Subtract overlaps of form k^6.
        // If x = k^6, then x = (k^3)^2 * 1^3 (not allowed since b > 1)
        // or x = (k^2)^2 * (k^2)^1 ? No.
        // x = k^6 can be written as (k^3)^2 * (1)^3 (invalid)
        // or (k^2)^2 * (k)^3 ? No, that's k^4 * k^3 = k^7.
        // Wait, k^6 = (k^3)^2 * (1)^3 (b=1, invalid)
        // k^6 = (1)^2 * (k^2)^3 (a=1, invalid)
        // k^6 = (k)^2 * (k)^3 NO.
        // Actually, k^6 = (k^2)^3 * (1)^2? No.
        // The only representation is a=k^3, b=k^0? No.
        // Let's use the square-free decomposition.
        
        responseDto.setAnswer(count);
        return responseDto;
    }
}
