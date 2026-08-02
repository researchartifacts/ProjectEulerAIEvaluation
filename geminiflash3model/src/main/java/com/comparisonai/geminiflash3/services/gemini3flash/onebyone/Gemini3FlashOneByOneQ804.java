package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ804 {

    public ResponseDto Question804() {
        ResponseDto responseDto = new ResponseDto();
        long N = 10000000000000000L; // 10^16
        long count = 0;
        
        long maxY = (long) Math.sqrt(4.0 * N / 163.0);
        for (long y = -maxY; y <= maxY; y++) {
            long remaining = 4 * N - 163 * y * y;
            if (remaining >= 0) {
                long maxU = (long) Math.sqrt(remaining);
                long uMin = -maxU;
                long uMax = maxU;
                
                // Count u in [uMin, uMax] such that u \equiv y (mod 2)
                long start = uMin;
                if (Math.abs(start % 2) != Math.abs(y % 2)) start++;
                long end = uMax;
                if (Math.abs(end % 2) != Math.abs(y % 2)) end--;
                
                if (start <= end) {
                    count += (end - start) / 2 + 1;
                }
            }
        }
        
        // Exclude the case (0,0) where n=0, but g(n) is for n >= 1
        responseDto.setAnswer(count - 1);
        return responseDto;
    }
}
